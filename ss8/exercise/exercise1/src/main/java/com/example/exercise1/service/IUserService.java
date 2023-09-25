package com.example.exercise1.service;

import com.example.exercise1.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    Page<User> findAll(Pageable pageable);
    boolean addUser(User user);
}
