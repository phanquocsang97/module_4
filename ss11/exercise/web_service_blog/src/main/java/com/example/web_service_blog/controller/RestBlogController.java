package com.example.web_service_blog.controller;

import com.example.web_service_blog.model.Blog;
import com.example.web_service_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Blog>> getListBlog(){
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Blog blog = blogService.findById(id);
        if(blog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(blog,HttpStatus.OK);
        }
    }
}
