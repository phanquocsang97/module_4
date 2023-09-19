package com.example.exercise.controller;

import com.example.exercise.model.Product;
import com.example.exercise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("showList",productService.findAll());
        return "list";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String saveInfo(@ModelAttribute Product product,
                           RedirectAttributes redirectAttributes){
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess","Create Success!!");
        return "redirect:create";
    }
    @PostMapping("/delete")
    public String delete(@ModelAttribute Product product,
                           RedirectAttributes redirectAttributes){
        productService.remove(product.getId());
        redirectAttributes.addFlashAttribute("mess","Delete Success!!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/showFormUpdate")
    public String showFormUpdate(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "update";
    }
    @PostMapping("/update")
    public String saveUpdate(@ModelAttribute Product product,
                           int id,
                           RedirectAttributes redirectAttributes){
        productService.update(id,product);
        redirectAttributes.addFlashAttribute("mess","Update Success!!");
        return "redirect:/product";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }

}
