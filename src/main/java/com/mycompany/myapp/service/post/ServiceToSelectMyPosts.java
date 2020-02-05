package com.mycompany.myapp.service.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.post.PostVo;
import com.mycompany.myapp.repository.post.DaoToSelectMyPosts;

@Service
public class ServiceToSelectMyPosts {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectMyPosts.class);

	@Autowired
	public DaoToSelectMyPosts daoToSelectMyPosts;

	@Autowired
	public PostVo postVo;

	public List<PostVo> selectMyPosts(long userId) {
		
		logger.info("SERVICE: selectMyPosts() called.");		
		
		return daoToSelectMyPosts.selectMyPosts(userId);

	}

}
