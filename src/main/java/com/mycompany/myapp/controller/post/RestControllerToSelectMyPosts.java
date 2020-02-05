package com.mycompany.myapp.controller.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.myapp.domain.ResponseVo;

@RestController
@RequestMapping("/*")
public class RestControllerToSelectMyPosts {

	static Logger logger = LoggerFactory.getLogger(RestControllerToSelectMyPosts.class);

	@Autowired
	public ResponseVo responseVo;

	@RequestMapping(value = "/post/my", method = RequestMethod.GET)
	public ResponseVo selectMyPosts() {

	}

}
