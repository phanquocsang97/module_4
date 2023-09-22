package com.example.exercise_app_blog.service;

import com.example.exercise_app_blog.model.Blog;
import com.example.exercise_app_blog.model.Category;
import com.example.exercise_app_blog.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean addCategory(Category category) {
        try {
            Category categoryEntity = categoryRepository.save(category);
            return categoryEntity != null;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteCategory(Category category) {
        try {
            Category categoryEntity = categoryRepository.findById(category.getId()).get();
            categoryRepository.delete(categoryEntity);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCategory(Category category) {
        try {
            categoryRepository.save(category);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).get();
    }
}
