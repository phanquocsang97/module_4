package com.example.web_service_blog.controller;

import com.example.web_service_blog.model.Blog;
import com.example.web_service_blog.model.Category;
import com.example.web_service_blog.service.IBlogService;
import com.example.web_service_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/categories")
public class RestCategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogService blogService;
    @GetMapping("")
    public ResponseEntity<List<Category>> getList(){
        List<Category> categoryList = categoryService.findAll();
        if(categoryList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(categoryList,HttpStatus.OK);
        }
    }

}
