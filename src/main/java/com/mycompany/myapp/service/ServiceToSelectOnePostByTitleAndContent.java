package com.mycompany.myapp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.repository.DaoToSelectOnePostByTitleAndContent;

@Service
public class ServiceToSelectOnePostByTitleAndContent {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOnePostByTitleAndContent.class);

	@Autowired
	DaoToSelectOnePostByTitleAndContent daoToSelectOnePostById;

	@Autowired
	PostVO postVO;

	public PostVO selectOnePostByTitleAndContent(PostVO postVO) {
		return postVO = daoToSelectOnePostById.selectOnePostByTitleAndContent(postVO);

	}

}
