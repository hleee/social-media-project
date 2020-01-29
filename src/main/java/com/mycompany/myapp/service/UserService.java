package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.controller.UserVO;
import com.mycompany.myapp.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserVO userVO;
	
	public UserVO selectByID(Long id) throws Exception{
		userVO =  userDAO.selectByID(id);
		System.out.println(userVO);
		return userVO;
	}
	
}
