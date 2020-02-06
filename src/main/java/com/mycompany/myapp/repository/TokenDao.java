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

	// 1. 토큰 발급 및 저장
	// insert 메서드는 DB에서 작업한 줄 개수를 정수 형태로 반환
	// 토큰표에 한 줄을 성공적으로 추가했으면 정수 1 반환
	public int insertOneToken(TokenVo tokenVo) throws DataAccessException {
		int integerOneIfInserted = sqlSession.insert("mapper.token.insertOneToken", tokenVo);
		return integerOneIfInserted;
	}

	// 2. 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		tokenVo = sqlSession.selectOne("mapper.token.selectOneTokenRowByToken", token);
		return tokenVo;
	}

}
