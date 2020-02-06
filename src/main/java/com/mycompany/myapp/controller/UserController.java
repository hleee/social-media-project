package com.mycompany.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.service.UserService;

@RestController
@RequestMapping("/*")
public class UserController {

	static Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public UserService userService;

	@Autowired
	public UserVo userVo;

	// 1. 회원 가입
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ResponseVo insertOneUser(@RequestBody UserVo userVo) throws Exception {

		logger.info("insertOneUser() called.");

		// 회원이 성공적으로 추가됐으면 정수 1 출력
		int integerOneIfInserted = userService.insertOneUser(userVo);
		logger.info("Integer 1 if new user inserted: " + integerOneIfInserted);

		// id와 createdAt을 responseVO에 담아주기 위해 가입 후 다시 한 번 조회
		// 그렇지 않고 그대로 반환하면 null 반환
		userVo = userService.selectOneUserByUsernameAndPassword(userVo);

		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(userVo);

		return responseVo;
	}

	// 2. 전체 회원 조회
	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ResponseVo selectAllUsers() throws Exception {

		logger.info("selectAllUsers() called.");

		// 전체 회원 정보를 allUsersList라는 List에 담음
		List<UserVo> allUsersList = userService.selectAllUsers();
		logger.info("allUsersList: " + allUsersList);

		// responseVo에 code, message, data 각각 설정
		// data는 모든 회원의 모든 정보 (id, username, password, createdAt)
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allUsersList);

		return responseVo;
	}

	// 3. ID로 단일 회원 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseVo selectOneUserById(@RequestParam("id") Long id) throws Exception {

		logger.info("selectOneUserByID() called.");

		// ID로 단일 회원을 조회한 후 userVO에 담음
		UserVo userVo = userService.selectOneUserById(id);
		logger.info("userVo: " + userVo);

		// responseVO에 code, message, data 각각 설정
		// data는 userVO에 담긴 단일 회원의 정보 (id, username, password, createdAt)
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(userVo);

		return responseVo;
	}

}
