package com.mycompany.myapp.service.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.TokenVO;
import com.mycompany.myapp.repository.token.DaoToSelectOneTokenRowByToken;

@Service
public class ServiceToSelectOneTokenRowByToken {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOneTokenRowByToken.class);

	@Autowired
	public DaoToSelectOneTokenRowByToken daoToSelectOneTokenRowByToken;

	@Autowired
	public TokenVO tokenVO;

	public TokenVO selectOneTokenRowWithToken(String token) {
		TokenVO tokenVO = daoToSelectOneTokenRowByToken.selectOneTokenRowByToken(token);
		return tokenVO;
	}

}
