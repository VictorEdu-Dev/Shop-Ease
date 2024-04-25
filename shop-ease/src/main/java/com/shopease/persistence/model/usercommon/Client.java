package com.shopease.controller.system.users.client;

import com.shopease.controller.system.users.DefaultUser;

public class Client extends DefaultUser {
	private int id;
	private String name;
	private String address;
	private String homeNumber;
	private String neighborhood;
	private String city;
	private String state;
	private String country;
	
	private String email;
	private String phoneNumber;
	
	public Client() {
		
	}
	
	public Client(String name, String address, 
			String homeNumber, String neighborhood, String city, 
			String state, String country, String email, 
			String phoneNumber) {
		super();
		this.name = name;
		this.address = address;
		this.homeNumber = homeNumber;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.country = country;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "[ " + "Name=" + name + ", address=" + address + ", homeNumber=" + homeNumber
				+ ", bairro=" + neighborhood + ", city=" + city + ", state=" + state + ", country=" + country + ", email="
				+ email + ", phoneNumber=" + phoneNumber  + " ]";
	}
}
