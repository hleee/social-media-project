package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.repository.TokenDao;

@Service
public class TokenService {

	static Logger logger = LoggerFactory.getLogger(TokenService.class);

	@Autowired
	TokenDao tokenDao;

	@Autowired
	TokenVo tokenVo;

	// 1. 토큰 발급 및 저장
	public int insertOneToken(TokenVo tokenVo) throws Exception {
		int integerOneIfInserted = tokenDao.insertOneToken(tokenVo);
		return integerOneIfInserted;
	}

	// 2. 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		TokenVo tokenVo = tokenDao.selectOneTokenRowByToken(token);
		return tokenVo;
	}

}
