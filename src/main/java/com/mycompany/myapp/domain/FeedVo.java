package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class FeedVo {

	private long userId;
	private long followeeId;
	private long postId;
	private String createdAt;

	public FeedVo() {
		super();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFolloweeId() {
		return followeeId;
	}

	public void setFolloweeId(long followeeId) {
		this.followeeId = followeeId;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "FeedVo [userId=" + userId + ", followeeId=" + followeeId + ", postId=" + postId + ", createdAt="
				+ createdAt + "]";
	}

}
