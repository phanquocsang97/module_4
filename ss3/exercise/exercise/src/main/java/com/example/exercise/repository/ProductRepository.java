package com.example.exercise.repository;

import com.example.exercise.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository{
    private static  List<Product> list;
    static {
        list.add(new Product(1,"T-Shirt",1000,"Global Brand","Gucci"));
        list.add(new Product(2,"Polo",1200,"Global Brand","Louis Vuitton"));
        list.add(new Product(1,"Jacket",1500,"Global Brand","Chanel"));
    }
    @Override
    public List<Product> findAll() {
        return list;
    }
}
