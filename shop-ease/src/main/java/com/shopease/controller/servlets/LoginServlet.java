package com.controller.servlets;

import java.io.IOException;

import com.controller.system.users.DefaultUser;
import com.controller.system.users.DefaultUserParameter;
import com.database.daos.AuthSessionDAO;

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
		user.setUserName(request.getParameter(DefaultUserParameter.USERNAME.getContent()));	 
		user.setPassword(request.getParameter(DefaultUserParameter.PASSWORD.getContent()));
		
		System.out.println(user.getUserName());

		if (AuthSessionDAO.validateCredencials(user)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", user.getUserName());

			session.setMaxInactiveInterval(60 * 60);

			String homeURI = request.getContextPath() + "/content/index.jsp";
			response.sendRedirect(homeURI);
		} else {
			response.sendRedirect("login.jsp?erro=1");
		}
	}


}


