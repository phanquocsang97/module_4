package com.example.exercise_app_blog.controller;

import com.example.exercise_app_blog.model.Blog;
import com.example.exercise_app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

//    @GetMapping("")
//    public String showList(Model model) {
//        model.addAttribute("showList", blogService.findAll());
//        return "blog/home";
//    }
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0",required = false) int page,
                           @RequestParam(defaultValue = "",required = false)String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page,2, Sort.by("date").ascending());
        Page<Blog> blogPage = blogService.findAll(pageable,searchName);
        model.addAttribute("blogPage",blogPage);
        model.addAttribute("searchName",searchName);
        return "blog/home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }
    @PostMapping("/create")
    public String saveInfo(@ModelAttribute Blog blog,
                           RedirectAttributes redirectAttributes) {
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Create Success!!");
        return "redirect:/blog";
    }
    @PostMapping("/delete")
    public String deleteBlog(@RequestParam int id,
                                RedirectAttributes redirectAttributes) {
        Blog blog = blogService.findById(id);
        blogService.deleteBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Delete Success!!");
        return "redirect:/blog";
    }
    @GetMapping("/showFormUpdate/{id}")
    public String showFormUpdate(@PathVariable int id,
                                 Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/update";
    }
    @PostMapping("/update")
    public String saveForm(@ModelAttribute Blog blog,
                             RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Update Success!!");
        return "redirect:/blog";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/detail";
    }

}
