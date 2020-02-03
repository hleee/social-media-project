package com.mycompany.myapp.service.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.repository.post.DaoToInsertOnePost;

public class ServiceToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(ServiceToInsertOnePost.class);

	@Autowired
	DaoToInsertOnePost daoToInsertOnePost;

	@Autowired
	PostVO postVO;

	public int insertOnePost(PostVO postVO) {
		int IntegerOneIfInserted = daoToInsertOnePost.insertOnePost(postVO);
		return IntegerOneIfInserted;
	}

}
