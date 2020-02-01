package com.mycompany.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.service.ServiceToSelectAllUsers;

@RestController
@RequestMapping("/*")
public class RestControllerToGetAllUsers {

	static Logger logger = LoggerFactory.getLogger(RestControllerToGetAllUsers.class);

	@Autowired
	ServiceToSelectAllUsers serviceToSelectAllUsers;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public HashMap<String, Object> listAll() throws Exception {
		List<UserVO> userList = serviceToSelectAllUsers.selectAllUsers();
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("code", HttpStatus.OK.value());
		map.put("message", "Success");
		map.put("data", userList);

		return map;
	}

}
