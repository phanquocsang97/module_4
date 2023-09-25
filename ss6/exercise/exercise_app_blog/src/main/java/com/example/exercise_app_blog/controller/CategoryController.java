package com.example.exercise_app_blog.controller;

import com.example.exercise_app_blog.model.Blog;
import com.example.exercise_app_blog.model.Category;
import com.example.exercise_app_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;
    @GetMapping("")
    public String showListCategory(Model model) {
        model.addAttribute("showListCategory", categoryService.findAll());
        return "category/home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @PostMapping("/create")
    public String saveInfo(@ModelAttribute Category category,
                           RedirectAttributes redirectAttributes) {
        categoryService.addCategory(category);
        redirectAttributes.addFlashAttribute("mess", "Create Success!!");
        return "redirect:/category";
    }
    @PostMapping("/delete")
    public String deleteCategory(@RequestParam int id,
                                RedirectAttributes redirectAttributes) {
        Category category = categoryService.findById(id);
        categoryService.deleteCategory(category);
        redirectAttributes.addFlashAttribute("mess", "Delete Success!!");
        return "redirect:/category";
    }
    @GetMapping("/showFormUpdateCategory/{id}")
    public String showFormUpdateCategory(@PathVariable int id,
                                 Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "category/update";
    }
    @PostMapping("/updateCategory")
    public String saveForm(@ModelAttribute Category category,
                             RedirectAttributes redirectAttributes) {
        categoryService.updateCategory(category);
        redirectAttributes.addFlashAttribute("mess", "Update Success!!");
        return "redirect:/category";
    }
    @GetMapping("/view/{id}")
    public String viewDetail(@PathVariable int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        return "redirect:/blog/";
    }
}
