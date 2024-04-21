package com.shopease.controller.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopease.controller.auth.enums.Action;
import com.shopease.controller.auth.enums.Constant;
import com.shopease.controller.auth.enums.Path;
import com.shopease.controller.system.users.DefaultUser;
import com.shopease.database.daos.AuthSessionDAO;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthLogin {
	@GetMapping(Action.AUTH_LOGIN) 
	public String form() {
		return Path.LOGIN_PAGE_ADMIN.getContent();
	}

	@RequestMapping(Action.TAKE_LOGIN)
	public String takeLogin(DefaultUser user, HttpSession session) {
		boolean isValid = AuthSessionDAO.validateCredencials(user);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		
		if(isValid) {
			session.setAttribute(Constant.ATRIBUTE_SESSION.getContent(), user);
			session.setMaxInactiveInterval(60 * 120);
			
			return Path.HOME_PAGE_DEFAULT.getContent();
		} else {
			return Action.REDIRECT_AUTHLOGIN;
		}
	}
	
	@GetMapping(Action.SYSTEM_ADMIN)
	public String enterAdmin() {
		return Path.SYSTEM_ADMIN_PROFILE.getContent();
	}
	
	@GetMapping(Action.REQ_LOGOUT_ADMIN)
	public String logout(HttpSession session) {
		session.invalidate();
		return Action.REDIRECT_AUTHLOGIN;
	}
	
}
