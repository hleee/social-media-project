package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.controller.RestAPIController;
import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.repository.DaoToInsertOneToken;

@Service
public class ServiceToInsertOneToken {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOneToken.class);

	@Autowired
	DaoToInsertOneToken daoToInsertOneToken;

	@Autowired
	TokenVO tokenVO;

	public int insertOneToken(TokenVO tokenVO) throws Exception {
		int integerOneIfInserted = daoToInsertOneToken.insertOneToken(tokenVO);
		return integerOneIfInserted;

	}

}
