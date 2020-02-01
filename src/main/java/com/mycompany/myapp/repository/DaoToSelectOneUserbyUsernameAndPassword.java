package com.mycompany.myapp.repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.controller.RestAPIController;

@Repository
public class DaoToSelectOneUserbyUsernameAndPassword {

	static Logger logger = LoggerFactory.getLogger(RestAPIController.class);
	
	@Autowired
	private SqlSession sqlSession;

	
}
