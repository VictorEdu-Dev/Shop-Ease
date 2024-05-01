package com.shopease.controller.adminarea.enums;

public enum Path {
	REGISTER_CLIENT_AREA("register-user-client/register-user-client"),
	VIEW_CLIENT_LIST("register-user-client/view-table-list"),
	REGISTER_PRODUCT_AREA("register-product/register-products"),
	CHAT_TEAM_AREA("web-chat-team/web-chat-team"),
	EMPLOYEE_AREA_SERVICE("employee-area-service/employee-area-service"),
	VIEW_EMPLOYEE_LIST("employee-area-service/view-employee-list"), 
	ADMIN_GENERAL_SYSTEM("login-page-admin/system-admin/system-admin-profile/admin-system");
	
	public final String path;
	
	Path(String path) {
		this.path = path;
	}
	
	public String getContent() {
		return path;
	}
	
	public String getContentForward() {
		return "forward:/WEB-INF/view/" + path + ".jsp";
	}
	
	public String getContentRedirect() {
		return "redirect:/WEB-INF/view/" + path + ".jsp";
	}
}
