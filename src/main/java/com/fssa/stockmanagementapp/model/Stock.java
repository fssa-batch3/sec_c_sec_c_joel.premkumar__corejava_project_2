package com.fssa.stockmanagementapp.model;

import java.time.LocalDateTime;

public class Stock {
	private int id;
	private String name;
	private String isin;
	private String description;
	private double price;
	private LocalDateTime creationDateTime;
	private int userId;


	public Stock() {

	}

	public Stock(String name, String isin, String description, double price) {
		this.name = name; 
		this.isin = isin;
		this.description = description;
		this.price = price;
	}


	
	
	public Stock(int id, String name, String isin, String description, double price, LocalDateTime creationDateTime,
			int userId) {
		super();
		this.id = id;
		this.name = name;
		this.isin = isin;
		this.description = description;
		this.price = price;
		this.creationDateTime = creationDateTime;
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(LocalDateTime creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", name=" + name + ", isin=" + isin + ", description=" + description + ", price="
				+ price + ", creationDateTime=" + creationDateTime + ", userId=" + userId + "]";
	}


}