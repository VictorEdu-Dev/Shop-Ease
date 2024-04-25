package com.shopease.controller.system.users.admin;

import com.shopease.controller.system.users.DefaultUser;

public class AdminUser extends DefaultUser {
	private String uniqueIdentifier;
	
	public AdminUser() {
		
	}
	
	public AdminUser(String uniqueIdentifier) {
		super();
		this.uniqueIdentifier = uniqueIdentifier;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	
	
}
