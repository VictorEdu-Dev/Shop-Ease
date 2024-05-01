package com.shopease.persistence.model.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "rg")
	private String rg;
	@Column(name = "issuing_authority")
	private String issuingAuthority;
	@Column(name = "cpf")
	private String cpf;
	@Column(name = "address")
	private String address;
	@Column(name = "home_number")
	private String homeNumber;
	@Column(name = "addition_information")
	private String additionInformation;
	@Column(name = "neighborhood")
	private String neighborhood;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "smartphone_number")
	private String smartphoneNumber;
	@Column(name = "ctps")
	private String ctps;
	@Column(name = "pis")
	private String pis;
	@Column(name = "birth")
	private String birth;
	
	/**
	 * @param rg
	 * @param issuingAuthority
	 * @param cpf
	 * @param address
	 * @param homeNumber
	 * @param additionInformation
	 * @param neighborhood
	 * @param city
	 * @param state
	 * @param phoneNumber
	 * @param smartphoneNumber
	 * @param ctps
	 * @param pis
	 * @param birth
	 */
	
	public Employee(String name, String rg, String issuingAuthority, String cpf, String address, String homeNumber,
			String additionInformation, String neighborhood, String city, String state, String phoneNumber,
			String smartphoneNumber, String ctps, String pis, String birth) {
		this.name = name;
		this.rg = rg;
		this.issuingAuthority = issuingAuthority;
		this.cpf = cpf;
		this.address = address;
		this.homeNumber = homeNumber;
		this.additionInformation = additionInformation;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.smartphoneNumber = smartphoneNumber;
		this.ctps = ctps;
		this.pis = pis;
		this.birth = birth;
	}
	
	public Employee() {
		this.name = "";
		this.rg = "";
		this.issuingAuthority = "";
		this.cpf = "";
		this.address = "";
		this.homeNumber = "";
		this.additionInformation = "";
		this.neighborhood = "";
		this.city = "";
		this.state = "";
		this.phoneNumber = "";
		this.smartphoneNumber = "";
		this.ctps = "";
		this.pis = "";
		this.birth = "";
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rg
	 */
	public String getRg() {
		return rg;
	}

	/**
	 * @param rg the rg to set
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}

	/**
	 * @return the issuingAuthority
	 */
	public String getIssuingAuthority() {
		return issuingAuthority;
	}

	/**
	 * @param issuingAuthority the issuingAuthority to set
	 */
	public void setIssuingAuthority(String issuingAuthority) {
		this.issuingAuthority = issuingAuthority;
	}

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the homeNumber
	 */
	public String getHomeNumber() {
		return homeNumber;
	}

	/**
	 * @param homeNumber the homeNumber to set
	 */
	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}

	/**
	 * @return the additionInformation
	 */
	public String getAdditionInformation() {
		return additionInformation;
	}

	/**
	 * @param additionInformation the additionInformation to set
	 */
	public void setAdditionInformation(String additionInformation) {
		this.additionInformation = additionInformation;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the smartphoneNumber
	 */
	public String getSmartphoneNumber() {
		return smartphoneNumber;
	}

	/**
	 * @param smartphoneNumber the smartphoneNumber to set
	 */
	public void setSmartphoneNumber(String smartphoneNumber) {
		this.smartphoneNumber = smartphoneNumber;
	}

	/**
	 * @return the ctps
	 */
	public String getCtps() {
		return ctps;
	}

	/**
	 * @param ctps the ctps to set
	 */
	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	/**
	 * @return the pis
	 */
	public String getPis() {
		return pis;
	}

	/**
	 * @param pis the pis to set
	 */
	public void setPis(String pis) {
		this.pis = pis;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}
}
