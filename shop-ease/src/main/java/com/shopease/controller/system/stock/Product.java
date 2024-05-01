package com.shopease.controller.system.stock;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_batch")
public class Product implements Serializable {
	private static final long serialVersionUID = -351563657586067466L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String category;
	private String description; 
	private String name;
	private String brand;
	
	private String manufacturingDate;
	private String expirationDate;
	
	private double price;
	
	public Product() {
		
	}

	public Product(String category, String description, String name, String brand, String manufacturingDate,
			String expirationDate, double price) {
		super();
		this.category = category;
		this.description = description;
		this.name = name;
		this.brand = brand;
		this.manufacturingDate = manufacturingDate;
		this.expirationDate = expirationDate;
		this.price = price;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

