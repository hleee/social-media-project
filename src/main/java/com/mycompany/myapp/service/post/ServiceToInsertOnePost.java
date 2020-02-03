package com.mycompany.myapp.service.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.repository.post.DaoToInsertOnePost;

@Service
public class ServiceToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOnePost.class);

	@Autowired
	DaoToInsertOnePost daoToInsertOnePost;

	@Autowired
	PostVO postVO;

	public int insertOnePost(PostVO postVO) {
		int integerOneIfInserted = daoToInsertOnePost.insertOnePost(postVO);
		logger.info("=== Service to insert one post ===");
		logger.info("Integer 1 if post inserted: " + integerOneIfInserted);
		return integerOneIfInserted;
	}

}
