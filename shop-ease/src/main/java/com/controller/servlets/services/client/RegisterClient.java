package com.controller.servlets.services.client;

import com.controller.servlets.services.Service;
import com.controller.system.users.client.Client;
import com.controller.system.users.client.UserClientParameter;
import com.database.daos.ClientDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterClient implements Service {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		Client client = new Client();
		client.setName(req.getParameter(UserClientParameter.NAME.getContent()));
		client.setAddress(req.getParameter(UserClientParameter.ADDRESS.getContent()));
		client.setBairro(req.getParameter(UserClientParameter.BAIRRO.getContent()));
		client.setCity(req.getParameter(UserClientParameter.CITY.getContent()));
		client.setState(req.getParameter(UserClientParameter.STATE.getContent()));
		client.setCountry(req.getParameter(UserClientParameter.COUNTRY.getContent()));
		client.setHomeNumber(req.getParameter(UserClientParameter.HOMENUMBER.getContent()));
		
		client.setPhoneNumber(req.getParameter(UserClientParameter.PHONENUMBER.getContent()));
		client.setEmail(req.getParameter(UserClientParameter.EMAIL.getContent()));
		
		System.out.println(client.toString());
		
		ClientDAO clientDAO = new ClientDAO();
		clientDAO.addClient(client);
		
		return null;
	}
}
