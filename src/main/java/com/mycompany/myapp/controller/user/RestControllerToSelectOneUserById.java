package com.mycompany.myapp.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.user.UserVO;
import com.mycompany.myapp.service.user.ServiceToSelectOneUserById;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectOneUserById {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectOneUserById.class);

	@Autowired
	private ServiceToSelectOneUserById serviceToSelectOneUserById;

	@Autowired
	public UserVO userVO;

	@Autowired
	public ResponseVO responseVO;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseVO selectOneUserById(@RequestParam("id") Long id) throws Exception {

		logger.info("selectOneUserByID() called.");

		// ID로 단일 회원을 조회한 후 userVO에 담음
		UserVO userVO = serviceToSelectOneUserById.selectOneUserById(id);
		logger.info("One user selected from database.");
		logger.info("id contained in userVO: " + id);

		// responseVO에 code, message, data 각각 설정
		// data는 userVO에 담긴 단일 회원의 정보 (id, username, password, createdAt)
		responseVO.setCode(HttpStatus.OK);
		responseVO.setMessage("Success");
		responseVO.setData(userVO);
		logger.info("code, message, and data set in responseVO.");
		logger.info("responseVO: " + responseVO);

		return responseVO;
	}

}
