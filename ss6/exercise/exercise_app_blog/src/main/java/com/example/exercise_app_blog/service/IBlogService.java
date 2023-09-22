package com.example.exercise_app_blog.service;

import com.example.exercise_app_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);
    boolean addBlog(Blog blog);
    boolean deleteBlog(Blog blog);
    boolean updateBlog(Blog blog);
    Blog findById(int id);
    Page<Blog> findAll(Pageable pageable,String name);
    Page<Blog> findAllByBlog(Pageable pageable,int idCategory);
}
