package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.service.TokenService;
import com.mycompany.myapp.service.UserService;
import com.mycompany.myapp.util.TokenMaker;

@RestController
@RequestMapping("/*")
public class TokenController {

	static Logger logger = LoggerFactory.getLogger(TokenController.class);

	@Autowired
	public TokenVo tokenVo;
	
	@Autowired
	public ResponseVo responseVo;
	
	@Autowired
	public TokenService tokenService;
	
	@Autowired
	public UserService userService;
	
	// 1. 토큰 등록
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseVo insertOneToken(@RequestBody UserVo userVoToDb) throws Exception {

		logger.info("insertOneToken() called to authorise user.");

		// userVO에서 id를 추출
		UserVo userVoFromDb = userService
				.selectOneUserByUsernameAndPassword(userVoToDb);
		long id = userVoFromDb.getId();
		logger.info("id retrieved from DB: " + id);

		// 토큰 발행
		String token = TokenMaker.makeToken();
		logger.info("Token created.");

		// tokenVo에 새로 만든 일련 번호와 DB의 user 표에서 불러온 id 저장
		tokenVo.setToken(token);
		tokenVo.setUserId(id);
		logger.info("tokenVO: token: " + token + ", id: " + id);

		// tokenVo에 담긴 정보를 데이터베이스의 token 표에 넣기
		tokenService.insertOneToken(tokenVo);
		logger.info("Token inserted into the database.");

		// responseVo에 code, message, data 설정
		// data는 토큰 일련 번호를 DB의 토큰 표에 넣고 같이 저장된 userId와 createdAt (토큰 생성 시간)
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(tokenVo);
		logger.info("code, message, and data set in responseVo");

		return responseVo;

	}
	
}
