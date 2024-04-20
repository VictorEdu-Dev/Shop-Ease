package com.controller.servlets.services.client;

import java.util.List;

import com.controller.servlets.services.Service;
import com.controller.system.users.client.Client;
import com.database.daos.ClientDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListClient implements Service{

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Client> clients = new ClientDAO().getClientList();
		req.setAttribute("clients", clients);
		
		return "content/pages/client-list/client-list.jsp";
	}

}
