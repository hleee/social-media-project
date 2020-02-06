package com.mycompany.myapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.PostVo;
import com.mycompany.myapp.domain.PostVoWithUser;
import com.mycompany.myapp.domain.UserVo;
import com.mycompany.myapp.repository.PostDao;
import com.mycompany.myapp.repository.UserDao;

@Service
public class PostService {

	static Logger logger = LoggerFactory.getLogger(PostService.class);

	@Autowired
	public PostDao postDao;

	@Autowired
	public UserDao userDao;
	
	@Autowired
	public PostVo postVo;

	@Autowired
	public UserVo userVo;

	@Autowired
	public PostVoWithUser postVoWithUser;

	// 1. 글 저장 API
	public int insertOnePost(PostVo postVo) {
		logger.info("PostService: insertOnePost() called.");

		int integerOneIfInserted = postDao.insertOnePost(postVo);
		logger.info("PostService: Integer 1 if post inserted: " + integerOneIfInserted);

		return integerOneIfInserted;
	}

	// 2. 전체 글 목록 조회 API
	public PostVoWithUser[] selectAllPostsDescending() {
		logger.info("PostService: selectAllPostsDescending() called.");

		// 전체 글을 역순으로 담은 목록 객체 생성
		List<PostVo> allPostsList = postDao.selectAllPostsDescending();

		// allPostsList의 길이와 같은 길이의 빈 배열 객체 생성
		PostVoWithUser[] allPostsListWithUsers = new PostVoWithUser[allPostsList.size()];

		for (int i = 0; i < allPostsListWithUsers.length; i++) {
			// allPostsList[i] 번째의 값에 + userVo 를 넣어
			// allPostsListWithUser에 담음
			// allPostsListWithUser의 길이까지 1씩 증가

			logger.info("PostService: For loop entered to fill in allPostsListWithUsers.");

			// id로 회원 정보를 조회해 가져옴
			long userIdOfAuthors = allPostsList.get(i).getUserId();
			logger.info("User id of authors retrieved.");
			UserVo userVo = userDao.selectOneUserByID(userIdOfAuthors);
			logger.info("userVo has retrieved user info.");

			// 두 VO 객체로부터 정보를 받아 한 군데로 모을 VO 객체 껍데기 생성
			PostVoWithUser postVoWithUser = new PostVoWithUser();

			// 회원 정보가 담긴 userVo를 user에 set
			postVoWithUser.setUser(userVo);
			logger.info("userVo set to postVoWithUser.");

			// 나머지 항목들도 손수 넣어줘야 함
			// allPostsList에 담긴 i 번째 PostVo 객체에서 getId()
			// 이후 새로 만든 껍데기인 postVoWithUser에 setId()
			long id = allPostsList.get(i).getId();
			postVoWithUser.setId(id);
			logger.info("id: " + id);

			long userId = allPostsList.get(i).getUserId();
			postVoWithUser.setUserId(userId);
			logger.info("userId: " + userId);

			String title = allPostsList.get(i).getTitle();
			postVoWithUser.setTitle(title);
			logger.info("title: " + title);

			String content = allPostsList.get(i).getContent();
			postVoWithUser.setContent(content);
			logger.info("content: " + content);

			String createdAt = allPostsList.get(i).getCreatedAt();
			postVoWithUser.setCreatedAt(createdAt);
			logger.info("createdAt: " + createdAt);

			allPostsListWithUsers[i] = postVoWithUser;

		}

		return allPostsListWithUsers;
	}
	
	// 3. 내가 쓴 글 조회 API
	public List<PostVo> selectMyPosts(long userId) {

		logger.info("SERVICE: selectMyPosts() called.");

		return postDao.selectMyPosts(userId);
	}

	// 4. 사용자 ID로 글 하나 조회
	public PostVo selectOnePostById(long id) {
		return postVo = postDao.selectOnePostById(id);
	}

}