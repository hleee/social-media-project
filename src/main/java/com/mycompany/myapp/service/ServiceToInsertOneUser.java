package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.UserDAO;

@Service
public class ServiceToInsertOneUser {

static Logger logger = LoggerFactory.getLogger(ServiceToInsertOneUser.class);
	
	@Autowired
	UserDAO userDAO;

	@Autowired
	UserVO tokenVO;
	
}
