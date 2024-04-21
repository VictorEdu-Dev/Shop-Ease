package com.shopease.controller.adminarea;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shopease.controller.adminarea.enums.Action;
import com.shopease.controller.adminarea.enums.Path;

@Controller
public class AdminSystem {
	
	@GetMapping(Action.REQ_CLIENT_REGISTER_AREA)
	public String clientRegisterArea() {
		System.out.println("Acessou o recurso mapeado.");
		return Path.REGISTER_CLIENT_AREA.getContent();
	}
	
	@GetMapping(Action.REQ_PRODUCT_REGISTER_AREA)
	public String productRegisterArea() {
		return Path.REGISTER_PRODUCT_AREA.getContent();
	}
	
}
