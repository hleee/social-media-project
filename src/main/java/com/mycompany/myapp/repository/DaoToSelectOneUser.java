package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.UserVO;

@Repository
public class DaoToSelectOneUser {

	@Autowired
	private SqlSession sqlSession;

	// 단일 회원 조회
	// 매개변수를 지정했으면 selectOne()에서 인자로 반복 설정해주어야 (id)
	public UserVO selectByID(Long id) throws DataAccessException {
		UserVO userVO = sqlSession.selectOne("mapper.userMapper.selectUser", id);
		return userVO;
	}
}
