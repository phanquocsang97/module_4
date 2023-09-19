package com.example.exercise.service;

import com.example.exercise.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void add(Product product);
    Product findById(int id);
    void remove(int id);
    void update(Integer id,Product product);
}
