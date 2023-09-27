package com.example.library.service;

import com.example.library.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
}
