package com.example.exercise_app_blog.service;

import com.example.exercise_app_blog.model.Blog;
import com.example.exercise_app_blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    boolean addCategory(Category category);
    boolean deleteCategory(Category category);
    boolean updateCategory(Category category);
    Category findById(int id);
}
