package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.UserDAO;

@Service
public class UserService {

	@Autowired
	UserDAO dao;
	UserVO vo;

	// 단일 회원 조회
	public UserVO selectByID(Long id) throws Exception {
		vo = dao.selectByID(id);
		System.out.println(vo);
		return vo;
	}

	// 전체 회원 조회
	public List<UserVO> selectAll() throws Exception {
		return dao.selectAll();
	}

	// 회원 가입

	// 로그인

}
