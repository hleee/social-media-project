package com.mycompany.myapp.controller;

import org.springframework.stereotype.Component;

@Component
public class UserVO {
	private int id;
	private String username;
	private String password;
	private String createdAt;

	public UserVO() {

	}
	
	

	public UserVO(int id, String username, String password, String createdAt) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String info = id + ", " + username + ", " + password + ", " + createdAt;
		return info;
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

}
