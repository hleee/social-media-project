package com.mycompany.myapp.controller;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.repository.UserDAO;

@Component
public class OuterUserVO {
	private int code;
	private String message;
	private UserDAO data;
	
		public OuterUserVO() {

		}

		public int getCode() {
			return code;
		}

		public void setCode(int i) {
			this.code = i;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public UserDAO getData() {
			return data;
		}

		public void setData(UserDAO data) {
			this.data = data;
		}

		// 콘솔창에 출력
		@Override
		public String toString() {
			String info = code + ", " + message + ", " + data;
			return info;
		}
		
	}

	
}
