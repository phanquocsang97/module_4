package com.example.exercise.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String detail;
    private String brand;

    public Product() {
    }

    public Product(int id, String name, int price, String detail, String brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.brand = brand;
    }

    public Product(String name, int price, String detail, String brand) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.brand = brand;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
