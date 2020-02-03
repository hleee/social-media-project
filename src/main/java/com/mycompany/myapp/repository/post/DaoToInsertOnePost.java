package com.mycompany.myapp.repository.post;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.PostVO;

@Repository
public class DaoToInsertOnePost {

	static Logger logger = LoggerFactory.getLogger(DaoToInsertOnePost.class);

	@Autowired
	private SqlSession sqlSession;

	@Autowired
	public PostVO postVO;

	public int insertOnePost(PostVO postVO) {
		int IntegerOneIfInserted = sqlSession.insert("mapper.post.insertOnePost", postVO);
		return IntegerOneIfInserted;
	}

}
