package com.shopease.controller.adminarea.enums;

public enum Path {
	REGISTER_CLIENT_AREA("register-user-client/register-user-client"),
	REGISTER_PRODUCT_AREA("register-product/register-products"), 
	CHAT_TEAM_AREA("web-chat-team/web-chat-team"),
	VIEW_CLIENT_LIST("register-user-client/view-table-list");
	
	public final String path;
	
	Path(String path) {
		this.path = path;
	}
	
	public String getContent() {
		return path;
	}
}
