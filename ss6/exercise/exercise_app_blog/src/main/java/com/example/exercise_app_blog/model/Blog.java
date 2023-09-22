package com.example.exercise_app_blog.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String title;
    private String content;
    @Column(columnDefinition = "date")
    private String date;
    private String author;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String name, String title, String content, String date, String author) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
    }

    public Blog(String name, String title, String content, String date, String author) {
        this.name = name;
        this.title = title;
        this.content = content;
        this.date = date;
        this.author = author;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
