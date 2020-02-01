package com.mycompany.myapp.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.RestAPIController;
import com.mycompany.myapp.domain.UserVO;

@Repository
public class DaoToSelectAllUsers {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<UserVO> selectAll() throws DataAccessException {
		List<UserVO> userList = null;
		userList = sqlSession.selectList("mapper.user.selectAll");
		return userList;
	}
	
}
