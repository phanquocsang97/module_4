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
        model.addAttribute("showList", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String saveInfoProduct(@ModelAttribute Product product,
                           RedirectAttributes redirectAttributes) {
        productService.add(product);
        redirectAttributes.addFlashAttribute("mess", "Create Success!!");
        return "redirect:create";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id,
                                RedirectAttributes redirectAttributes) {
        Product product = productService.findById(id);
        productService.remove(product);
        redirectAttributes.addFlashAttribute("mess", "Delete Success!!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/showFormUpdate")
    public String showFormUpdate(@PathVariable int id,
                                 Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String saveProduct(@ModelAttribute Product product,
                             RedirectAttributes redirectAttributes) {
        productService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Update Success!!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String viewDetailProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/detail";
    }
}
