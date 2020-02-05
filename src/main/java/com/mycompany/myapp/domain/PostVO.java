package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class PostVO {

	private Long id;
	private Long userId;
	private String title;
	private String content;
	private String createdAt;
	private Object userInfo;

	public PostVO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Object getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Object userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		String info = "PostVO: id: " + id + ", userId: " + userId + ", title: " + title + ", content: " + content
				+ ", createdAt: " + createdAt + ", userInfo: " + userInfo;
		return info;
	}

}
