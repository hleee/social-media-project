package com.mycompany.myapp.service.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.repository.user.DaoToSelectAllUsers;

@Service
public class ServiceToSelectAllUsers {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectAllUsers.class);

	@Autowired
	DaoToSelectAllUsers daoToSelectAllUsers;

	@Autowired
	UserVo userVO;

	public List<UserVo> selectAllUsers() throws Exception {
		return daoToSelectAllUsers.selectAllUsers();
	}

}
