package com.example.exercise.repository;

import com.example.exercise.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    Product findById(int id);
    boolean delete(int id);
    boolean update(int id, Product product);

}
