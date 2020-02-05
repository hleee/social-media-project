package com.mycompany.myapp.domain.user;

import org.springframework.stereotype.Component;

@Component
public class UserVoWithoutPassword {

	private Long id;
	private String username;
	private String createdAt;

	public UserVoWithoutPassword() {

	}

	public Long getId() {
		return id;
	}

	public void setId(int i) {
		this.id = (long) i;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	// 콘솔창에 출력
	@Override
	public String toString() {
		String info = "UserVO: id: " + id + ", username: " + username + ", join date: " + createdAt;
		return info;
	}

}