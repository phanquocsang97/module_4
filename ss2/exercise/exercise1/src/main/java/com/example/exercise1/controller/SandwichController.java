package com.example.exercise1.controller;

import com.example.exercise1.service.ISandwichSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @Autowired
    private ISandwichSerivce sandwichSerivce ;

    @GetMapping("/showSpices")
    public String showForm() {
        return "result";
    }

    @RequestMapping("/showResult")
    public String save(@RequestParam(value = "condiment", required = false,defaultValue = "Please choose!!!") String[] condiment
            , Model model) {
        String[] spices = sandwichSerivce.spices(condiment);
        model.addAttribute("spices", spices);
        return "result";
    }

}
