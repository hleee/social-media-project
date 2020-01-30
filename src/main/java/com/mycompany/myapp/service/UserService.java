package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserVO userVO;
	
	// 단일 회원 조회
	public UserVO selectByID(Long id) throws Exception {
		userVO =  userDAO.selectByID(id);
		System.out.println(userVO);
		return userVO;
	}
	
	// 전체 회원 조회
	public UserVO selectAllUsers(Long id) throws Exception {
		List<UserVO> userList = userDAO.selectAllUsers();
		System.out.println(userVO);
		return userVO;
	}
	
	// 로그인
	
	
	// 회원 가입
	
}
