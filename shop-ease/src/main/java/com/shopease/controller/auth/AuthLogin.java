package com.shopease.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopease.controller.auth.enums.Action;
import com.shopease.controller.auth.enums.Constant;
import com.shopease.controller.auth.enums.Path;
import com.shopease.persistence.model.admin.AdminUser;
import com.shopease.persistence.repository.CrudRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthLogin {
	
	private CrudRepository<AdminUser, String, Object> authSess;
	
	@Autowired
	public AuthLogin(@Qualifier("jpaAuthSessionDAO") CrudRepository<AdminUser, String, Object> authSess) {
		this.authSess = authSess;
	}

	@GetMapping(Action.AUTH_LOGIN) 
	public String form() {
		return Path.LOGIN_PAGE_ADMIN.getContent();
	}

	@RequestMapping(Action.TAKE_LOGIN)
	public String takeLogin(AdminUser user, HttpSession session) {
		if(session.getAttribute(Constant.ATRIBUTE_SESSION.getContent()) != null) {
			return Path.SYSTEM_ADMIN_PROFILE.getContent();
		} else if(authSess.findByObject(user) != null) {
			session.setAttribute(Constant.ATRIBUTE_SESSION.getContent(), user);
			return Path.SYSTEM_ADMIN_PROFILE.getContent();
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
