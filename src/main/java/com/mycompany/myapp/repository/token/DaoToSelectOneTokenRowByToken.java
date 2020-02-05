package com.mycompany.myapp.repository.token;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.TokenVO;

@Repository
public class DaoToSelectOneTokenRowByToken {

	static Logger logger = LoggerFactory.getLogger(DaoToSelectOneTokenRowByToken.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public TokenVO tokenVO;

	public TokenVO selectOneTokenRowByToken(String token) {
		tokenVO = sqlSession.selectOne("mapper.token.selectOneTokenRowByToken", token);
		return tokenVO;
	}

}