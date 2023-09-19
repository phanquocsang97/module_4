package com.example.exercise.controller;

import com.example.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/showList")
    public String showList(Model model) {
        model.addAttribute("showList",productService.findAll());
        return "list";
    }
}
