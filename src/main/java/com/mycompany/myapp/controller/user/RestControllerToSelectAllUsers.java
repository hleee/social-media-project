package com.mycompany.myapp.controller.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.service.user.ServiceToSelectAllUsers;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectAllUsers {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectAllUsers.class);

	@Autowired
	private ServiceToSelectAllUsers serviceToSelectAllUsers;

	@Autowired
	public ResponseVo responseVo;

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ResponseVo selectAllUsers() throws Exception {

		logger.info("REST_CONTROLLER: selectAllUsers() called.");

		// 전체 회원 정보를 allUsersList라는 List에 담음
		List<UserVo> allUsersList = serviceToSelectAllUsers.selectAllUsers();
		logger.info("REST_CONTROLLER: All user information selected from database.");

		// responseVo에 code, message, data 각각 설정
		// data는 모든 회원의 모든 정보 (id, username, password, createdAt)
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allUsersList);
		logger.info("REST_CONTROLLER: code, message, and data set in responseVo.");

		return responseVo;
	}

}
