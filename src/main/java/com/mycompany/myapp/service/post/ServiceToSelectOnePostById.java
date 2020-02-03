package com.mycompany.myapp.service.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVO;
import com.mycompany.myapp.repository.post.DaoToSelectOnePostById;

@Service
public class ServiceToSelectOnePostById {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectOnePostById.class);

	@Autowired
	DaoToSelectOnePostById daoToSelectOnePostById;

	@Autowired
	PostVO postVO;

	public PostVO selectOnePostById(long id) {
		return postVO = daoToSelectOnePostById.selectOnePostById(id);

	}

}
