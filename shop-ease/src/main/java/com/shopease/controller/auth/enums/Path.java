package com.shopease.controller.auth.enums;

public enum Path {
	LOGIN_PAGE_ADMIN("login-page-admin/login"),
	HOME_PAGE_ADMIN(""),
	HOME_PAGE_DEFAULT("content/index");

	private final String content;
	
	Path(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
}
