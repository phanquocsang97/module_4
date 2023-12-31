package com.example.product.dto;

import org.hibernate.annotations.Check;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDto {
    private int id;

    private String name;

    private double price;
    private String description;
    private double discount;
    private String image;
    private int quantity;

    public ProductDto() {
    }

    public ProductDto(int id, String name, double price, String description, double discount, String image, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.discount = discount;
        this.image = image;
        this.quantity = quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Double.compare(that.discount, discount) == 0 && quantity == that.quantity && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, description, discount, image, quantity);
    }
}
