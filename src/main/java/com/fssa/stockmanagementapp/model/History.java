package com.fssa.stockmanagementapp.model;

import java.sql.Timestamp;

public class History {
    private int id;
    private int userId;
    private String stockName;
    private int quantity;
    private double inr;
    private double usd;
    private Timestamp purchasedDate;

    // Constructors
    public History() {
    }

    public History(int userId, String stockName, int quantity, double inr, double usd) {
        this.userId = userId;
        this.stockName = stockName;
        this.quantity = quantity;
        this.inr = inr;
        this.usd = usd;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getInr() {
        return inr;
    }

    public void setInr(double inr) {
        this.inr = inr;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public Timestamp getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Timestamp purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @Override
    public String toString() {
        return "History [id=" + id + ", userId=" + userId + ", stockName=" + stockName + ", quantity=" + quantity
                + ", inr=" + inr + ", usd=" + usd + ", purchasedDate=" + purchasedDate + "]";
    }
}

