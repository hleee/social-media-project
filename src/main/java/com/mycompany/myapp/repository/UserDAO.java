package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.domain.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;

	// 단일 회원 조회
	// 매개변수를 지정했으면 selectOne()에서 인자로 반복 설정해주어야 (id)
	public UserVO selectByID(Long id) throws DataAccessException {
		UserVO vo = sqlSession.selectOne("mapper.userMapper.selectUser", id);
		return vo;
	}

	// 전체 회원 조회
	public List<UserVO> selectAll() throws DataAccessException {
		List<UserVO> userList = null;
		userList = sqlSession.selectList("mapper.userMapper.selectAll");
		return userList;
	}

	// 회원 가입
	// 반환형은 int, 전달 중인 객체는 UserVO, mapper를 찾아서 id가 insertUser인 걸 찾아서 vo 객체를 전달
	// DB에 잘 들어가면 DB에서 작업한 줄의 개수 반환 -- 한 줄 작업했으니 1 반환
	public int insertUser(UserVO vo) throws DataAccessException {
		int newUser = sqlSession.insert("mapper.userMapper.insertUser", vo);
		return newUser;
	}

	// 로그인
	public UserVO login(UserVO vo) throws DataAccessException {
		UserVO loginVO = sqlSession.selectOne("mapper.userMapper.login", vo);
		return loginVO;
	}

	// 토큰;insert는 int 반환
	public int insertToken(TokenVO tokenVO) throws DataAccessException {
		return sqlSession.insert("mapper.userMapper.insertToken", tokenVO);
	}

}
