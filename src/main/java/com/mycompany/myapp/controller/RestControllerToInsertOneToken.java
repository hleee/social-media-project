package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToInsertOneToken;
import com.mycompany.myapp.service.ServiceToSelectOneUserByUsernameAndPassword;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneToken.class);

	@Autowired
	ServiceToInsertOneToken serviceToInsertOneToken;

	@Autowired
	ServiceToSelectOneUserByUsernameAndPassword serviceToSelectOneUserByUsernameAndPassword;

	@Autowired
	UserVO userVO;

	@Autowired
	TokenVO tokenVO;
	
	@Autowired
	TokenMaker tokenMaker;

	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public UserVO insertOneToken(@RequestBody UserVO userVoToDb) throws Exception {

		logger.info("insertOneToken() called.");
		
		// userVO에서 id를 추출
		UserVO userVoFromDb = serviceToSelectOneUserByUsernameAndPassword.selectOneUserByUsernameAndPassword(userVoToDb);
		long id = userVoFromDb.getId();
		logger.info("id: " + id);
		
		// 토큰 발행
		String token = tokenMaker.makeToken();
		logger.info("Token created.");
		
		// tokenVO에 일련 번호와 id 저장
		tokenVO.setToken(token);
		tokenVO.setUserId(id);
		logger.info("Within tokenVO: token: " + token + ", id: " + id);
		
		// tokenVO에 담긴 정보를 데이터베이스의 token 표에 넣기
		serviceToInsertOneToken.insertOneToken(tokenVO);
		logger.info("Token inserted into the database.");
		
		
		return userVoFromDb;

	}

}
