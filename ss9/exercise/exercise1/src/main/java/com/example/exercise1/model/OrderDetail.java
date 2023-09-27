package com.example.exercise1.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String namePerson;
    @Column(columnDefinition = "date")
    private String borrowDay;
    @Column(columnDefinition = "date")
    private String giveBackDay;
    @Column(unique = true)
    private String codeNumber;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
    public OrderDetail() {
    }

    public OrderDetail(int id, String namePerson, String borrowDay, String giveBackDay, String codeNumber, Book book) {
        this.id = id;
        this.namePerson = namePerson;
        this.borrowDay = borrowDay;
        this.giveBackDay = giveBackDay;
        this.codeNumber = codeNumber;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getBorrowDay() {
        return borrowDay;
    }

    public void setBorrowDay(String borrowDay) {
        this.borrowDay = borrowDay;
    }

    public String getGiveBackDay() {
        return giveBackDay;
    }

    public void setGiveBackDay(String giveBackDay) {
        this.giveBackDay = giveBackDay;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
