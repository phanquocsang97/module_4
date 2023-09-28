package com.example.product.controller;

import com.example.product.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
@RequestMapping("cart")
public class CartController {
    @GetMapping
    public String showCart(@SessionAttribute(value = "cart", required = false) CartDto cartDto,
                           Model model) {
        model.addAttribute("cart", cartDto);
        return "cart/list";
    }
}
