package com.mycompany.myapp.repository.token;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.token.TokenVo;

@Repository
public class DaoToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(DaoToInsertOneToken.class);

	@Autowired
	private SqlSession sqlSession;

	// insert 메서드는 DB에서 작업한 줄 개수를 정수 형태로 반환
	// 토큰표에 한 줄을 성공적으로 추가했으면 정수 1 반환
	public int insertOneToken(TokenVo tokenVo) throws DataAccessException {
		int integerOneIfInserted = sqlSession.insert("mapper.token.insertOneToken", tokenVo);
		return integerOneIfInserted;
	}
}
