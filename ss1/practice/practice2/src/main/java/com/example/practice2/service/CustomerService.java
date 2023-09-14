package com.example.practice2.service;

import com.example.practice2.model.Customer;
import com.example.practice2.repository.CustomerRepository;
import com.example.practice2.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
