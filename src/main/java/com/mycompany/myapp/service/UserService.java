package com.mycompany.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.UserDao;

@Service
public class UserService {

	static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserDao userDao;

	@Autowired
	public UserVo userVo;

	// 단일 회원 삽입
	public int insertOneUser(UserVo userVo) throws Exception {
		return userDao.insertOneUser(userVo);
	}

	// 전체 회원 조회
	public List<UserVo> selectAllUsers() throws Exception {
		return userDao.selectAllUsers();
	}

	// ID로 단일 회원 조회
	public UserVo selectOneUserById(Long id) {
		return userVo = userDao.selectOneUserById(id);
	}

	// username과 password로 단일 회원 조회
	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) {
		return userDao.selectOneUserByUsernameAndPassword(userVo);
	}

}
