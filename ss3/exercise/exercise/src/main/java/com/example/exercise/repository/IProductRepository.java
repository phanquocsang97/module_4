package com.example.exercise.repository;

import com.example.exercise.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void remove(Product product);

    void update(Product product);
}
