package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.RestAPIController;
import com.mycompany.myapp.domain.TokenVO;

@Repository
public class DaoToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	private SqlSession sqlSession;

	// 토큰;insert는 int 반환
	public int insertToken(TokenVO tokenVO) throws DataAccessException {
		return sqlSession.insert("mapper.token.insertToken", tokenVO);
	}
}
