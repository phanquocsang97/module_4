package com.example.exercise.service;

import com.example.exercise.model.Product;
import com.example.exercise.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Product product) {
        productRepository.remove(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
