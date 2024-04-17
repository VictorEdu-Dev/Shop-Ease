package com.controller.servlets.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Service {
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception;	
}
