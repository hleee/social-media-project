package com.mycompany.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.UserDao;

@Service
public class UserService {

	static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	public UserDao userDao;

	@Autowired
	public UserVo userVo;

	@Autowired
	public ResponseVo responseVo;

	// 단일 회원 삽입
	public ResponseVo insertOneUser(UserVo userVo) throws Exception {
		userDao.insertOneUser(userVo);
		userVo = userDao.selectOneUserByUsernameAndPassword(userVo);
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(userVo);
		return responseVo;
	}

	// 전체 회원 조회
	public ResponseVo selectAllUsers() throws Exception {
		List<UserVo> allUsersList = userDao.selectAllUsers();
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allUsersList);
		return responseVo;
	}

	// ID로 단일 회원 조회
	public ResponseVo selectOneUserById(Long id) {
		userVo = userDao.selectOneUserById(id);
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(userVo);
		return responseVo;
	}

	// username과 password로 단일 회원 조회
	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) {
		return userDao.selectOneUserByUsernameAndPassword(userVo);
	}

}
