package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.ResponseVO;
import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO uDAO;
	UserVO uVO;
	ResponseVO rVO;
	
	// 단일 회원 조회
	public UserVO selectByID(Long id) throws Exception {
		uVO =  uDAO.selectByID(id);
		System.out.println(uVO);
		return uVO;
	}
	
	// 전체 회원 조회
	public ResponseVO selectAll(Long id) throws Exception {
		rVO = (ResponseVO) uDAO.selectAll();
		System.out.println(rVO);
		return rVO;
	}

	public List<UserVO> listAll() {
		return (List<UserVO>) uVO;
	}

	
	// 로그인
	
	
	// 회원 가입
	
}
