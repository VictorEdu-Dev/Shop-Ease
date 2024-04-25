package com.shopease.controller.auth.enums;

public enum Constant {
	ATRIBUTE_SESSION("loggedInUser");
		
	private final String content;
		
	Constant(String content) {
		this.content = content;
	}
		
	public String getContent() {
		return content;
	}
}