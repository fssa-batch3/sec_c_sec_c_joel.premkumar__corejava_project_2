package com.fssa.stockmanagementapp.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Stock {
    private int id;
    private String name;
    private String isin;
    private String description;
    private double price;
    private LocalDate createDate;
    private LocalTime createdTime;
    private LocalDate expireDate;
    private LocalTime expireTime;


    public Stock(String name, String isin, String description, double price, LocalDate createDate,
                 LocalTime createdTime, LocalDate expireDate, LocalTime expireTime) {
        super();
        this.name = name;
        this.isin = isin;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.createdTime = createdTime;
        this.expireDate = expireDate;
        this.expireTime = expireTime;
    }

    public Stock() {
        // TODO Auto-generated constructor stub
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalTime createdTime) {
        this.createdTime = createdTime;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    public LocalTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalTime expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isin='" + isin + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createDate=" + createDate +
                ", createdTime=" + createdTime +
                ", expireDate=" + expireDate +
                ", expireTime=" + expireTime +
                '}';
    }

}
