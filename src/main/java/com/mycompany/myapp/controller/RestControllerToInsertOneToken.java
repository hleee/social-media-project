package com.mycompany.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToInsertOneToken;
import com.mycompany.myapp.service.ServiceToSelectOneUserByUsernameAndPassword;
import com.mycompany.myapp.util.TokenMaker;

@RestController
@RequestMapping("/*")
public class RestControllerToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(RestControllerToInsertOneToken.class);

	@Autowired
	private ServiceToInsertOneToken serviceToInsertOneToken;

	@Autowired
	private ServiceToSelectOneUserByUsernameAndPassword serviceToSelectOneUserByUsernameAndPassword;

	@Autowired
	public UserVO userVO;

	@Autowired
	public ResponseVO responseVO;

	@Autowired
	public TokenVO tokenVO;

	@Autowired
	private TokenMaker tokenMaker;

	// Inserting token = authorising
	@RequestMapping(value = "/auth", method = RequestMethod.POST)
	public ResponseVO insertOneToken(@RequestBody UserVO userVoToDb) throws Exception {

		logger.info("insertOneToken() called to authorise user.");

		// userVO에서 id를 추출
		UserVO userVoFromDb = serviceToSelectOneUserByUsernameAndPassword
				.selectOneUserByUsernameAndPassword(userVoToDb);
		long id = userVoFromDb.getId();
		logger.info("id retrieved from DB: " + id);

		// 토큰 발행
		String token = tokenMaker.makeToken();
		logger.info("Token created.");

		// tokenVO에 새로 만든 일련 번호와 DB의 user 표에서 불러온 id 저장
		tokenVO.setToken(token);
		tokenVO.setUserId(id);
		logger.info("tokenVO: token: " + token + ", id: " + id);

		// tokenVO에 담긴 정보를 데이터베이스의 token 표에 넣기
		serviceToInsertOneToken.insertOneToken(tokenVO);
		logger.info("Token inserted into the database.");

		// responseVO에 code, message, data 설정
		// data는 토큰 일련 번호를 DB의 토큰 표에 넣고 같이 저장된 userId와 createdAt (토큰 생성 시간)
		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(tokenVO);
		logger.info("code, message, and data set in responseVO");

		return responseVO;

	}

}
