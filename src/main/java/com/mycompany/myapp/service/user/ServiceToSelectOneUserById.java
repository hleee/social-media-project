package com.mycompany.myapp.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.UserVO;
import com.mycompany.myapp.repository.user.DaoToSelectOneUserById;

@Service
public class ServiceToSelectOneUserById {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOneUserById.class);

	@Autowired
	DaoToSelectOneUserById daoToSelectOneUserById;

	@Autowired
	UserVO userVO;

	public UserVO selectOneUserById(Long id) {
		return userVO = daoToSelectOneUserById.selectOneUserByID(id);
	}
}
