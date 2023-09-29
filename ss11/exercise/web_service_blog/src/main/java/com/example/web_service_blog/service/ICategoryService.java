package com.example.web_service_blog.service;

import com.example.web_service_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean addCategory(Category category);
    boolean deleteCategory(Category category);
    boolean updateCategory(Category category);
    Category findById(int id);

}
