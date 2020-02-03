package com.mycompany.myapp.domain;

import org.springframework.stereotype.Component;

@Component
public class UserVO {
	
	private Long id;
	private String username;
	private String password;
	private String createdAt;

	public UserVO() {

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		String info = "UserVO: id: " + id + ", username: " + username + ", password: " + password + ", join date: "
				+ createdAt;
		return info;
	}

}