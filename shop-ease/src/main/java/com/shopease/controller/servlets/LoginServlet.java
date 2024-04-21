package com.shopease.controller.servlets;

import java.io.IOException;

import com.shopease.controller.system.users.DefaultUser;
import com.shopease.controller.system.users.DefaultUserParameter;
import com.shopease.database.daos.AuthSessionDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DefaultUser user = new DefaultUser();
		user.setUsername(request.getParameter(DefaultUserParameter.USERNAME.getContent()));	 
		user.setPassword(request.getParameter(DefaultUserParameter.PASSWORD.getContent()));
		
		System.out.println(user.getUsername());

		if (AuthSessionDAO.validateCredencials(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUsername());

			session.setMaxInactiveInterval(60 * 60);

			String homeURI = request.getContextPath() + "/content/index.jsp";
			response.sendRedirect(homeURI);
		} else {
			response.sendRedirect("login.jsp?erro=1");
		}
	}


}


