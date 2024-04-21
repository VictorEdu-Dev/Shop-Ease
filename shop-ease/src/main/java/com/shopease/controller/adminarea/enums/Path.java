package com.shopease.controller.adminarea.enums;

public enum Path {
	REGISTER_CLIENT_AREA("register-user-client/register-user-client"),
	REGISTER_PRODUCT_AREA("register-product/register-products");
	
	public final String path;
	
	Path(String path) {
		this.path = path;
	}
	
	public String getContent() {
		return path;
	}
}
