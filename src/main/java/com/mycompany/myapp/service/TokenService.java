package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.TokenDao;
import com.mycompany.myapp.repository.UserDao;
import com.mycompany.myapp.util.TokenMaker;

@Service
public class TokenService {

	static Logger logger = LoggerFactory.getLogger(TokenService.class);

	@Autowired
	public TokenDao tokenDao;

	@Autowired
	public TokenVo tokenVo;
	
	@Autowired
	public UserDao userDao;
	
	@Autowired
	public UserVo userVo;
	
	// Service에 비즈니스 로직을 구현 --> 컨트롤러와 다오 사이에서 데이터 가공 및 자료형 조율, 조정
	// 1. 토큰 발급 및 저장
	public TokenVo insertOneToken(UserVo userVoToDb) throws Exception {
		logger.info("insertOneToken() called.");

		// userVO에서 id를 추출
		UserVo userVoFromDb = userDao
				.selectOneUserByUsernameAndPassword(userVoToDb);
		long id = userVoFromDb.getId();
		logger.info("id retrieved from DB: " + id);

		// 토큰 발행
		String token = TokenMaker.makeToken();
		logger.info("token: " + token);

		// tokenVo에 새로 만든 일련 번호와 DB의 user 표에서 불러온 id 저장
		tokenVo.setToken(token);
		tokenVo.setUserId(id);
		logger.info("tokenVo: " + token);

		// tokenVo에 담긴 정보를 데이터베이스의 token 표에 넣기
		int integerOneIfInserted = tokenDao.insertOneToken(tokenVo);
		logger.info("Integer 1 if inserted: " + integerOneIfInserted);

		return tokenVo;
	}

	// 2. 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		logger.info("selectOneTokenRowByToken() called.");

		TokenVo tokenVo = tokenDao.selectOneTokenRowByToken(token);
		logger.info("tokenVo: " + tokenVo);

		return tokenVo;
	}

}
