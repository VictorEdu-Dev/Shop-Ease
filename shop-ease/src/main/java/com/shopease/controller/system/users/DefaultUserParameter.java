package com.controller.system.users;

public enum DefaultUserParameter {
	NAME("name"),
	USERNAME("username"),
	EMAIL("email"),
	PHONENUMBER("phone_number"),
	PASSWORD("password");
	
	private String content;
	
	private DefaultUserParameter(String content) {
		this. content = content;
	}
	
	public String getContent() {
		return content;
	}
}