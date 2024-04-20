package com.shopease.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shopease.controller.auth.enums.Action;
import com.shopease.controller.auth.enums.Constant;
import com.shopease.controller.auth.enums.Path;
import com.shopease.controller.system.users.DefaultUser;
import com.shopease.database.daos.AuthSessionDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthLogin {
	@RequestMapping(value = Action.AUTH_LOGIN, method = RequestMethod.GET) 
	public String form() {
		System.out.println("Passou pelo método form");
		return Path.LOGIN_PAGE_ADMIN.getContent();
	}

	@RequestMapping(Action.TAKE_LOGIN)
	public String takeLogin(DefaultUser user, HttpSession session) {
		boolean isValid = AuthSessionDAO.validateCredencials(user);
		
		if(isValid) {
			session.setAttribute(Constant.ATRIBUTE_SESSION.getContent(), user);
			session.setMaxInactiveInterval(60 * 120);
			
			return Path.HOME_PAGE_DEFAULT.getContent();
		}
		return Action.REDIRECT_AUTHLOGIN;
	}
}
