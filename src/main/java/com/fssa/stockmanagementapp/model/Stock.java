package com.fssa.stockmanagementapp.model;

import java.time.LocalDate;

public class Stock {
	private int id;
	private String name;
	private String isin;
	private String description;
	private double price;
	private LocalDate createDate;
	private LocalDate expireDate;

	public Stock(int id, String name, String isin, String description, double price, LocalDate createDate,
			LocalDate expireDate) {
		this.id = id;
		this.name = name;
		this.isin = isin;
		this.description = description;
		this.price = price;
		this.createDate = createDate;
		this.expireDate = expireDate;
	}

	public Stock() {

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

	public void setPrice(double d) {
		this.price = d;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public LocalDate getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}

//	public static void main(String[] args) {
//
//		Stock stock = new Stock(1, "Amazon", "Abcd12345", "Apple Shares", 2000, LocalDate.of(2023, 07, 31),
//				LocalDate.of(2025, 07, 31));
//
//		StockService stockService = new StockService(new StockValidator(), new StockDao());
//
//		try {
//			stockService.addStock(stock);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
