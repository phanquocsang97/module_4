package com.example.exercise_app_blog.controller;

import com.example.exercise_app_blog.model.Blog;
import com.example.exercise_app_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("showList", blogService.findAll());
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "create";
    }
    @PostMapping("/create")
    public String saveInfo(@ModelAttribute Blog blog,
                           RedirectAttributes redirectAttributes) {
        blogService.addBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Create Success!!");
        return "redirect:/blog";
    }
    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id,
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
        return "update";
    }
    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute Blog blog,
                             RedirectAttributes redirectAttributes) {
        blogService.updateBlog(blog);
        redirectAttributes.addFlashAttribute("mess", "Update Success!!");
        return "redirect:/blog";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "/detail";
    }

}
