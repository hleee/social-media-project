package com.mycompany.myapp.service.post;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.myapp.domain.post.PostVo;
import com.mycompany.myapp.domain.post.PostVoWithUser;
import com.mycompany.myapp.domain.user.UserVo;
import com.mycompany.myapp.repository.post.DaoToSelectAllPostsDescending;
import com.mycompany.myapp.repository.user.DaoToSelectOneUserById;

@Service
public class ServiceToSelectAllPostsDescending {

	static Logger logger = LoggerFactory.getLogger(ServiceToSelectAllPostsDescending.class);

	@Autowired
	public DaoToSelectAllPostsDescending daoToSelectAllPostsDescending;

	@Autowired
	public DaoToSelectOneUserById daoToSelectOneUserById;

	@Autowired
	public PostVoWithUser postVoWithUser;

	@Autowired
	public PostVo postVo;

	public PostVoWithUser[] selectAllPostsDescending() {

		logger.info("SERVICE: selectAllPostsDescending() called.");

		// 전체 글을 역순으로 담은 목록 객체 생성
		List<PostVo> allPostsList = daoToSelectAllPostsDescending.selectAllPostsDescending();

		// allPostsList의 길이와 같은 길이의 빈 배열 객체 생성
		PostVoWithUser[] allPostsListWithUsers = new PostVoWithUser[allPostsList.size()];

		for (int i = 0; i < allPostsListWithUsers.length; i++) {
			// allPostsList[i] 번째의 값에 + userVo 를 넣어
			// allPostsListWithUser에 담음
			// allPostsListWithUser의 길이까지 1씩 증가

			logger.info("For loop entered to fill in allPostsListWithUsers.");

			// id로 회원 정보를 조회해 가져옴
			long userIdOfAuthors = allPostsList.get(i).getUserId();
			logger.info("User id of authors retrieved.");
			UserVo userVo = daoToSelectOneUserById.selectOneUserByID(userIdOfAuthors);
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

}
