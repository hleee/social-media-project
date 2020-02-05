package com.mycompany.myapp.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.repository.user.DaoToSelectOneUserByUsernameAndPassword;

@Service
public class ServiceToSelectOneUserByUsernameAndPassword {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOneUserByUsernameAndPassword.class);

	@Autowired
	DaoToSelectOneUserByUsernameAndPassword dao;

	@Autowired
	UserVo userVo;

	public UserVo selectOneUserByUsernameAndPassword(UserVo userVo) {
		UserVo oneUserByUsernameAndPassword = dao.selectOneUserByUsernameAndPassword(userVo);
		return oneUserByUsernameAndPassword;
	}

}
