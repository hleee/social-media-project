package com.mycompany.myapp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.UserService;

@RestController
public class RestAPIController {

	private static final Logger logger = LoggerFactory.getLogger(RestAPIController.class);

	@Autowired
	UserService uService;
	ResponseVO rVO;

	// 한 명 조회
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public UserVO selectByID(@RequestParam("id") Long id) throws Exception {
		UserVO uVO = uService.selectByID(id);
		System.out.println(uVO);
		return uVO;
	}

	// 전체 회원 조회
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseVO listAll() throws Exception {
		List<UserVO> userList = uService.listAll();
		for (UserVO user : userList) {
			System.out.println(user);
		}

		rVO.setCode(HttpStatus.OK.value());
		rVO.setMessage("Success");
		rVO.setData(userList);

		return rVO;

	}

//	// 회원 가입
//	@PostMapping("/user")
//	public 

}
