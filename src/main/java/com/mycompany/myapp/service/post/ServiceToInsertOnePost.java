package com.mycompany.myapp.service.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.post.PostVo;
import com.mycompany.myapp.repository.post.DaoToInsertOnePost;

@Service
public class ServiceToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOnePost.class);

	@Autowired
	DaoToInsertOnePost daoToInsertOnePost;

	@Autowired
	PostVo postVo;

	public int insertOnePost(PostVo postVo) {
		int integerOneIfInserted = daoToInsertOnePost.insertOnePost(postVo);
		logger.info("=== Service to insert one post ===");
		logger.info("Integer 1 if post inserted: " + integerOneIfInserted);
		return integerOneIfInserted;
	}

}
