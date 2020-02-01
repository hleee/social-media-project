package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.DaoToSelectOneUserByUsernameAndPassword;

@Service
public class ServiceToSelectOneUserByUsernameAndPassword {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOneUserByUsernameAndPassword.class);

	@Autowired
	DaoToSelectOneUserByUsernameAndPassword dao;

	@Autowired
	UserVO userVO;

	public UserVO selectOneUserByUsernameAndPassword(UserVO userVO) {
		UserVO oneUserByUsernameAndPassword = dao.selectOneUserByUsernameAndPassword(userVO);
		return oneUserByUsernameAndPassword;
	}

}
