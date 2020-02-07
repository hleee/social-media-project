package com.mycompany.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.PostVoWithUser;
import com.mycompany.myapp.domain.ResponseVo;
import com.mycompany.myapp.domain.TokenVo;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.PostDao;
import com.mycompany.myapp.repository.TokenDao;
import com.mycompany.myapp.repository.UserDao;

@Service
public class PostService {

	static Logger logger = LoggerFactory.getLogger(PostService.class);

	@Autowired
	public PostDao postDao;

	@Autowired
	public UserDao userDao;

	@Autowired
	public TokenDao tokenDao;

	@Autowired
	public PostVo postVo;

	@Autowired
	public ResponseVo responseVo;

	@Autowired
	public UserVo userVo;

	@Autowired
	public PostVoWithUser postVoWithUser;

	// 글 저장
	public ResponseVo insertOnePost(PostVo postVo, String token) {
		TokenVo tokenVo = tokenDao.selectOneTokenRowByToken(token);
		Long userId = tokenVo.getUserId();
		postVo.setUserId(userId);
		postDao.insertOnePost(postVo);
		long id = postVo.getId();
		postVo = postDao.selectOnePostById(id);
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVo);
		return responseVo;
	}

	// 전체 글 목록 조회
	public ResponseVo selectAllPostsDescending() {
		List<PostVo> allPostsList = postDao.selectAllPostsDescending();
		PostVoWithUser[] allPostsListWithUsers = new PostVoWithUser[allPostsList.size()];
		for (int i = 0; i < allPostsListWithUsers.length; i++) {
			long userIdOfAuthor = allPostsList.get(i).getUserId();
			UserVo userVo = userDao.selectOneUserById(userIdOfAuthor);
			PostVoWithUser postVoWithUser = new PostVoWithUser();
			postVoWithUser.setUser(userVo);
			long id = allPostsList.get(i).getId();
			postVoWithUser.setId(id);
			long userId = allPostsList.get(i).getUserId();
			postVoWithUser.setUserId(userId);
			String title = allPostsList.get(i).getTitle();
			postVoWithUser.setTitle(title);
			String content = allPostsList.get(i).getContent();
			postVoWithUser.setContent(content);
			String createdAt = allPostsList.get(i).getCreatedAt();
			postVoWithUser.setCreatedAt(createdAt);
			allPostsListWithUsers[i] = postVoWithUser;
		}
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(allPostsListWithUsers);
		return responseVo;
	}

	// 내 글 조회
	public ResponseVo selectMyPosts(long userId) {
		List<PostVo> myPostsList = postDao.selectMyPosts(userId);
		PostVoWithUser[] myPostsListWithUser = new PostVoWithUser[myPostsList.size()];
		for (int i = 0; i < myPostsListWithUser.length; i++) {
			UserVo userVo = userDao.selectOneUserById(userId);
			PostVoWithUser postVoWithUser = new PostVoWithUser();
			postVoWithUser.setUser(userVo);
			long id = myPostsList.get(i).getId();
			postVoWithUser.setId(id);
			long userId1 = myPostsList.get(i).getUserId();
			postVoWithUser.setUserId(userId1);
			String title = myPostsList.get(i).getTitle();
			postVoWithUser.setTitle(title);
			String content = myPostsList.get(i).getContent();
			postVoWithUser.setContent(content);
			String createdAt = myPostsList.get(i).getCreatedAt();
			postVoWithUser.setCreatedAt(createdAt);
			myPostsListWithUser[i] = postVoWithUser;
		}
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(myPostsListWithUser);
		return responseVo;
	}

	// 사용자 ID로 글 하나 조회 (상세조회)
	public ResponseVo selectOnePostById(long postId) {
		postVo = postDao.selectOnePostById(postId);
		long id = postVo.getId();
		long userId = postVo.getUserId();
		String title = postVo.getTitle();
		String content = postVo.getContent();
		String createdAt = postVo.getCreatedAt();
		postVoWithUser.setId(id);
		postVoWithUser.setUserId(userId);
		postVoWithUser.setTitle(title);
		postVoWithUser.setContent(content);
		postVoWithUser.setCreatedAt(createdAt);
		userVo = userDao.selectOneUserById(userId);
		postVoWithUser.setUser(userVo);
		responseVo.setCode(HttpStatus.OK);
		responseVo.setMessage("Success");
		responseVo.setData(postVoWithUser);		 
		return responseVo;
	}
	
	// 글 삭제
	public ResponseVo deleteOnePost(long id) {
		int integerOneIfDeleted = postDao.deleteOnePost(id);
		if (integerOneIfDeleted == 1) {
			postVo = postDao.selectOnePostById(id);
			responseVo.setCode(HttpStatus.OK);
			responseVo.setMessage("Success");
			responseVo.setData(postVo);
			return responseVo;
		} else {
			responseVo.setCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseVo.setMessage("Error");
			responseVo.setData(null);
			return responseVo;
		}
	}
}
