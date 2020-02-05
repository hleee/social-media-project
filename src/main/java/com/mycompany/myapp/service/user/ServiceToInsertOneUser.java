package com.mycompany.myapp.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.user.UserVO;
import com.mycompany.myapp.repository.user.DaoToInsertOneUser;

@Service
public class ServiceToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOneUser.class);

	@Autowired
	DaoToInsertOneUser daoToInsertOneUser;

	@Autowired
	UserVO userVO;

	// DB에 성공적으로 추가하면 작업한 줄 개수 반환 (정수 1)
	public int insertOneUser(UserVO userVO) throws Exception {
		int integerOneIfInserted = daoToInsertOneUser.insertOneUser(userVO);
		return integerOneIfInserted;
	}

}
