package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;

	// 매개변수를 지정했으면 selectOne()에서 반복해주어야 (id)
	public UserVO selectByID(Long id) throws DataAccessException {
		UserVO userVO = sqlSession.selectOne("mapper.board.selectUser", id);
		return userVO;
	}

}
