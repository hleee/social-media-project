package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.UserVo;

@Repository
public class UserDao {

	static Logger logger = LoggerFactory.getLogger(UserDao.class);

	@Autowired
	private SqlSession sqlSession;

	// 1. 회원 가입
	// 회원 가입 기능 구현
	// insert 메서드는 DB에서 작업한 줄 개수를 정수 형태로 반환
	// 사용자 표에 한 줄을 성공적으로 추가했으면 정수 1 반환
	// DB쪽으로 전달 중인 객체는 userVO
	// 매퍼에서 id가 insertOneUser인 SQL문을 찾아서 userVO 객체를 전달
	public int insertOneUser(UserVo userVo) throws DataAccessException {
		logger.info("insertOneUser() called");

		int integerOneIfInserted = sqlSession.insert("mapper.user.insertOneUser", userVo);
		logger.info("Integer 1 if inserted: " + integerOneIfInserted);

		return integerOneIfInserted;
	}

	// 2. 전체 회원 조회
	// 반환되는 자료는 목록 형태
	public List<UserVo> selectAllUsers() throws DataAccessException {
		logger.info("selectAllUsers() called");

		List<UserVo> allUsersList = null;
		allUsersList = sqlSession.selectList("mapper.user.selectAllUsers");
		logger.info("allUsersList: " + allUsersList);

		return allUsersList;
	}

	// 3. ID로 단일 회원 조회
	// 전달되는 매개변수의 자료형과 이름을 지정했으면 sqlSession 메서드 내에서도 인자로 반복 설정해주어야 함
	// 여기서는 Long id의 경우
	public UserVo selectOneUserById(Long id) throws DataAccessException {
		logger.info("selectOneUserById() called");

		UserVo userVo = sqlSession.selectOne("mapper.user.selectOneUserById", id);
		logger.info("userVo: " + userVo);

		return userVo;
	}

	// 4. username과 password로 단일 회원 조회
	// 로그인에 사용
	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) throws DataAccessException {
		logger.info("selectOneUserByUsernameAndPassword() called");

		UserVo oneUserByUsernameAndPassword = sqlSession.selectOne("mapper.user.selectOneUserByUsernameAndPassword",
				userVo);
		logger.info("oneUserByUsernameAndPassword: " + oneUserByUsernameAndPassword);

		return oneUserByUsernameAndPassword;
	}

}
