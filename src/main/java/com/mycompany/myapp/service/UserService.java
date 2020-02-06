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

	// 1. 회원 가입
	// DB에 성공적으로 추가하면 작업한 줄 개수 반환 (정수 1)
	public int insertOneUser(UserVo userVo) throws Exception {
		logger.info("insertOneUser() called.");
		
		int integerOneIfInserted = userDao.insertOneUser(userVo);
		logger.info("Integer 1 if inserted: " + integerOneIfInserted);
		
		return integerOneIfInserted;
	}

	// 2. 전체 회원 조회
	public List<UserVo> selectAllUsers() throws Exception {
		logger.info("selectAllUsers() called.");
		
		return userDao.selectAllUsers();
	}

	// 3. ID로 단일 회원 조회
	public UserVo selectOneUserById(Long id) {
		logger.info("selectOneUserById() called.");

		return userVo = userDao.selectOneUserById(id);
	}

	// 4. username과 password로 단일 회원 조회
	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) {
		logger.info("selectOneUserByUsernameAndPassword() called.");

		UserVo oneUserByUsernameAndPassword = userDao.selectOneUserByUsernameAndPassword(userVo);
		return oneUserByUsernameAndPassword;
	}

}
