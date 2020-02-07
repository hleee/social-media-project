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

	// 토큰 발급 및 저장
	public TokenVo insertOneToken(UserVo userVo) throws Exception {
		userVo = userDao.selectOneUserByUsernameAndPassword(userVo);
		long id = userVo.getId();
		String token = TokenMaker.makeToken();
		tokenVo.setToken(token);
		tokenVo.setUserId(id);
		tokenDao.insertOneToken(tokenVo);
		return tokenDao.selectOneTokenRowByToken(token);
	}

	// 토큰으로 토큰 테이블의 열 정보 조회
	public TokenVo selectOneTokenRowByToken(String token) {
		return tokenDao.selectOneTokenRowByToken(token);
	}

}
