package com.example.exercise.repository;

import com.example.exercise.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("from Product", Product.class);
        return typedQuery.getResultList();
    }

    @Transactional
    @Override
    public boolean add(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Transactional
    @Override
    public boolean delete(int id) {
        try {
            Product productEntity = findById(id);
            entityManager.remove(productEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    @Transactional
    @Override
    public boolean update(int id, Product product) {
        try {
            Product productEntity = findById(id);
            productEntity.setName(product.getName());
            productEntity.setPrice(product.getPrice());
            productEntity.setDetail(product.getDetail());
            productEntity.setBrand(product.getBrand());
            entityManager.merge(productEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
