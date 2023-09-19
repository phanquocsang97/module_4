package com.example.exercise.repository;

import com.example.exercise.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static  List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"T-Shirt",1000,"Global Brand","Gucci"));
        productList.add(new Product(2,"Polo",1200,"Global Brand","Louis Vuitton"));
        productList.add(new Product(1,"Jacket",1500,"Global Brand","Chanel"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public void update(Integer id, Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(id, product);
            }
        }
    }
}
