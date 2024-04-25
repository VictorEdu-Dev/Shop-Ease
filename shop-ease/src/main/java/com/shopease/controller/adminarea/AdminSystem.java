package com.shopease.controller.adminarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopease.controller.adminarea.enums.Action;
import com.shopease.controller.adminarea.enums.Path;
import com.shopease.persistence.model.usercommon.Client;
import com.shopease.persistence.repository.CrudRepository;

@Controller
public class AdminSystem {
	
	private CrudRepository<Client, String, Object> clientRegister;
	
	@Autowired
	public AdminSystem(@Qualifier("jpaClientDAO") CrudRepository<Client, String, Object> clientRegister) {
		this.clientRegister = clientRegister;
	}
	
	@GetMapping(Action.REQ_CLIENT_REGISTER_AREA)
	public String clientRegisterArea() {
		return Path.REGISTER_CLIENT_AREA.getContent();
	}
	
	@PostMapping(Action.REQ_SUBMIT_CLIENT)
	public String submitClient(Client client, 
			@RequestParam("phone_number") String phoneNumber,
			@RequestParam("home_number") String homeNumber) {
		client.setHomeNumber(homeNumber);
		client.setPhoneNumber(phoneNumber);
		System.out.println(client.toString());
		clientRegister.save(client);
		return Path.REGISTER_CLIENT_AREA.getContent();
	}
	
	@GetMapping(Action.REQ_LOAD_LIST_CLIENT)
	public String loadClientList(Model model) {
		model.addAttribute("clients", clientRegister.findListObject());
		return Path.VIEW_CLIENT_LIST.getContent();
	}
	
	@GetMapping(Action.REQ_PRODUCT_REGISTER_AREA)
	public String productRegisterArea() {
		return Path.REGISTER_PRODUCT_AREA.getContent();
	}
	
	@GetMapping(Action.REQ_CHAT_TEAM_AREA)
	public String chatTeamArea() {
		return Path.CHAT_TEAM_AREA.getContent();
	}
}
