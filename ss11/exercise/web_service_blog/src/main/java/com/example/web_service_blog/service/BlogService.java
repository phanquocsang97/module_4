package com.example.web_service_blog.service;

import com.example.web_service_blog.model.Blog;
import com.example.web_service_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public boolean addBlog(Blog blog) {
        try {
            Blog blogEntity = blogRepository.save(blog);
            return blogEntity != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteBlog(Blog blog) {
        try {
            Blog blogEntity = blogRepository.findById(blog.getId()).get();
            blogRepository.delete(blogEntity);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBlog(Blog blog) {
        try {
            blogRepository.save(blog);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(int id) {
        return  blogRepository.findById(id).get();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name) {
        return blogRepository.findAllByNameContaining(pageable,name);
    }

    @Override
    public Page<Blog> findAllByBlog(Pageable pageable, int idCategory) {
        return blogRepository.findAllByBlog(pageable,idCategory);
    }

    @Override
    public List<Blog> searchBlogByCategory(int id) {
        return blogRepository.findByCategory_Id(id);
    }

    @Override
    public Page<Blog> searchByName(Pageable pageable, String searchName) {
        return blogRepository.searchByName(pageable,"%" +  searchName + "%");
    }
}
