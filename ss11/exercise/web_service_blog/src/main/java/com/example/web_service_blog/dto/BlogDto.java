package com.example.web_service_blog.dto;

import com.example.web_service_blog.model.Category;

public class BlogDto {
    private int id;
    private String title;
    private String content;
    private String author;
    private String time;
    private Category category;

    public BlogDto() {
    }

    public BlogDto(int id, String title, String content, String author, String time, Category category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.time = time;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
