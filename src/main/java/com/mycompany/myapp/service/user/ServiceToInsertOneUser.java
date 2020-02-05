package com.mycompany.myapp.service.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.repository.user.DaoToInsertOneUser;

@Service
public class ServiceToInsertOneUser {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOneUser.class);

	@Autowired
	DaoToInsertOneUser daoToInsertOneUser;

	@Autowired
	UserVo userVo;

	// DB에 성공적으로 추가하면 작업한 줄 개수 반환 (정수 1)
	public int insertOneUser(UserVo userVo) throws Exception {
		int integerOneIfInserted = daoToInsertOneUser.insertOneUser(userVo);
		return integerOneIfInserted;
	}

}
