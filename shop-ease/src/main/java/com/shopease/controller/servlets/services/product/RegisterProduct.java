package com.shopease.controller.servlets.services.product;

import java.io.IOException;

import com.shopease.controller.servlets.services.Service;
import com.shopease.controller.system.stock.Product;
import com.shopease.database.daos.ProductDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterProduct implements Service {
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String brand = request.getParameter("brand");
		String manufactureDate = request.getParameter("date-manufacturing");
		String expirationDate = request.getParameter("date-expiration");
		String price = request.getParameter("price");
		String description = request.getParameter("description");

		Product p = new Product();
		p.setName(name);
		p.setCategory(category);
		p.setPrice(Double.parseDouble(price));
		p.setManufacturingDate(manufactureDate);
		p.setExpirationDate(expirationDate);
		p.setBrand(brand);
		p.setDescription(description);
		
		ProductDAO dao = new ProductDAO();
		dao.addProduct(p);
		
		return null;
	}

}
