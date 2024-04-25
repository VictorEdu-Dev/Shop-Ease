package com.shopease.persistence.model.usercommon;

import com.shopease.persistence.model.DefaultUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client_user")
public class Client extends DefaultUser {
	private static final String NAME = "name";
	private static final String ADDRESS = "address";
	private static final String HOMENUMBER = "home_number";
	private static final String NEIGHBORHOOD = "neighborhood";
	private static final String CITY = "city";
	private static final String STATE = "state";
	private static final String COUNTRY = "country";
	private static final String EMAIL = "email";
	private static final String PHONENUMBER = "phone_number";

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = NAME)
	private String name;
	@Column(name = ADDRESS)
	private String address;
	@Column(name = HOMENUMBER)
	private String homeNumber;
	@Column(name = NEIGHBORHOOD)
	private String neighborhood;
	@Column(name = CITY)
	private String city;
	@Column(name = STATE)
	private String state;
	@Column(name = COUNTRY)
	private String country;
	@Column(name = EMAIL)
	private String email;
	@Column(name = PHONENUMBER)
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

