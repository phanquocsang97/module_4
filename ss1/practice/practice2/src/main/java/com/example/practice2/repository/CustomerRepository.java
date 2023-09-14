package com.example.practice2.repository;

import com.example.practice2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(1,"Sang","sang@mgmail.com","hue"));
        customerList.add(new Customer(2,"Hau","hau@mgmail.com","da nang"));
        customerList.add(new Customer(3,"Long","long@mgmail.com","da nang"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }
}
