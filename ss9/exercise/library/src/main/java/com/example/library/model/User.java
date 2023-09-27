package com.example.library.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUsers;

    @Column(name = "name_users")
    private String nameUsers;

    public User(int idUsers, String nameUsers) {
        this.idUsers = idUsers;
        this.nameUsers = nameUsers;
    }

    public User() {
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public String getNameUsers() {
        return nameUsers;
    }

    public void setNameUsers(String nameUsers) {
        this.nameUsers = nameUsers;
    }
}
