package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.TokenVo;

@Repository
public class TokenDao {

	static Logger logger = LoggerFactory.getLogger(TokenDao.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public TokenVo tokenVo;

	// 토큰 발급 및 저장
	public int insertOneToken(TokenVo tokenVo) throws DataAccessException {
		return sqlSession.insert("mapper.token.insertOneToken", tokenVo);
	}

	// 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		return sqlSession.selectOne("mapper.token.selectOneTokenRowByToken", token);
	}

}
