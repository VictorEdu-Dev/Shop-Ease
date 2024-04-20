package com.shopease.controller.system.users.client;

public enum UserClientParameter {
	
	/*
	 * Para associar dados às constantes enum, 
	 * declare campos de instância e escreva 
	 * um construtor que receba os dados e os 
	 * armazene nos campos.
	 * */
	
	NAME("name"),
	ADDRESS("address"),
	HOMENUMBER("home_number"),
	BAIRRO("bairro"),
	CITY("city"),
	STATE("state"),
	COUNTRY("country"),
	EMAIL("email"),
	PHONENUMBER("phone_number");
	
	private UserClientParameter(String content) {
		this.content = content;
	}

	private final String content;
	
	public String getContent() {
		return content;
	}
}
