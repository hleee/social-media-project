package com.mycompany.myapp.repository.user;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.user.UserVo;

@Repository
public class DaoToSelectOneUserById {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectOneUserById.class);

	@Autowired
	private SqlSession sqlSession;

	// ID로 단일 회원 조회
	// 전달되는 매개변수의 자료형과 이름을 지정했으면 sqlSession 메서드 내에서도 인자로 반복 설정해주어야 함
	// 여기서는 Long id의 경우
	public UserVo selectOneUserByID(Long id) throws DataAccessException {
		UserVo userVo = sqlSession.selectOne("mapper.user.selectOneUserById", id);
		return userVo;
	}
}
