package com.mycompany.myapp.service.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.post.PostVoWithUser;
import com.mycompany.myapp.repository.post.DaoToSelectAllPostsDescending;

@Service
public class ServiceToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectAllPostsDescending.class);

	@Autowired
	public DaoToSelectAllPostsDescending daoToSelectAllPostsDescending;

	@Autowired
	public PostVoWithUser postVoWithUser;

	public List<PostVoWithUser> selectAllPostsDescending() {
		logger.info("SERVICE: selectAllPostsDescending() called.");
		return daoToSelectAllPostsDescending.selectAllPostsDescending();
	}

}
