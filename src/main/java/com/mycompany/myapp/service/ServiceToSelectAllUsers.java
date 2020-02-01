package com.mycompany.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.DaoToSelectAllUsers;

@Service
public class ServiceToSelectAllUsers {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectAllUsers.class);

	@Autowired
	DaoToSelectAllUsers daoToSelectAllUsers;

	@Autowired
	UserVO userVO;

	public List<UserVO> selectAllUsers() throws Exception {
		return daoToSelectAllUsers.selectAllUsers();
	}

}
