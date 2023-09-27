package com.example.exercise1.dto;

import com.example.exercise1.model.OrderDetail;

import javax.validation.constraints.Size;

public class BookDto {
    private int id;
    @Size(min = 3,max = 45,message = "Enter at least 3 characters and maximum 45 characters")
    private String name;
    @Size(min = 3,max = 45,message = "Enter at least 3 characters and maximum 45 characters")
    private String author;
    @Size(min = 3,max = 45,message = "Enter at least 3 characters and maximum 45 characters")
    private String category;
    private int quantity;


    public BookDto() {
    }

    public BookDto(int id, String name, String author, String category, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.category = category;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
