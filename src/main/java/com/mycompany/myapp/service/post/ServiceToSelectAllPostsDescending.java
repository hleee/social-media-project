package com.mycompany.myapp.service.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.repository.post.DaoToSelectAllPostsDescending;

@Service
public class ServiceToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectAllPostsDescending.class);

	@Autowired
	public DaoToSelectAllPostsDescending daoToSelectAllPostsDescending;

	@Autowired
	public PostVO postVO;

	public List<PostVO> selectAllPostsDescending() {
		List<PostVO> allPostsList = daoToSelectAllPostsDescending.selectAllPostsDescending();
		logger.info("SERVICE: selectAllPostsDescending() called.");
		return allPostsList;
	}

}
