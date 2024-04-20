package com.controller.system.purchase.authenticator;

import com.controller.system.users.client.Client;

public class DeliveryAddress {
	private Client client;
	private String streetName;
	private String numberHome;
	private String typeHousing;
	private String neighborhood;
	private String city;
	private String state;
	
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getNumberHome() {
		return numberHome;
	}
	
	public void setNumberHome(String numberHome) {
		this.numberHome = numberHome;
	}
	
	public String getTypeHousing() {
		return typeHousing;
	}
	
	public void setTypeHousing(String typeHousing) {
		this.typeHousing = typeHousing;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
}

