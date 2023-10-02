package com.example.web_service_blog.controller;

import com.example.web_service_blog.model.Blog;
import com.example.web_service_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
//    @GetMapping("")
//    public ResponseEntity<List<Blog>> getListBlog(){
//        List<Blog> blogList = blogService.findAll();
//        if (blogList.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(blogList,HttpStatus.OK);
//    }
    @GetMapping("")
    public ResponseEntity<Page<Blog>> getListBlog(@RequestParam(defaultValue = "0",required = false) int page,
                                                  @RequestParam(defaultValue = "",required = false) String nameSearch){
        Pageable pageable = PageRequest.of(page,2);
        Page<Blog> blogPage = blogService.searchByName(pageable,nameSearch);
        if (blogPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage,HttpStatus.OK);
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

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Blog>> searchBlogByCategory(@PathVariable int id){
        List<Blog> blogByCategory = blogService.searchBlogByCategory(id);
        if(blogByCategory.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(blogByCategory,HttpStatus.OK);
        }
    }
}
