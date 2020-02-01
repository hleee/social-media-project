package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.RestAPIController;
import com.mycompany.myapp.domain.UserVO;

@Repository
public class DaoToSelectOneUser {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	
	@Autowired
	private SqlSession sqlSession;

	// 단일 회원 조회
	// 매개변수를 지정했으면 selectOne()에서 인자로 반복 설정해주어야 (id)
	public UserVO selectByID(Long id) throws DataAccessException {
		UserVO userVO = sqlSession.selectOne("mapper.user.selectUser", id);
		return userVO;
	}
}
