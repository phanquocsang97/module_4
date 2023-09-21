package com.example.exercise_app_blog.service;

import com.example.exercise_app_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    boolean addBlog(Blog blog);
    boolean deleteBlog(Blog blog);
    boolean updateBlog(Blog blog);
    Blog findById(int id);
}
