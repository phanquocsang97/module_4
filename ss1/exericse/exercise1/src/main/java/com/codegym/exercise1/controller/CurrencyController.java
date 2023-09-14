package com.codegym.exercise1.controller;

import com.codegym.exercise1.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;
    @GetMapping("/show")
    public String showMoney(){
        return "show";
    }
    @GetMapping("/result")
    public String result(@RequestParam int usd, Model model){
        double vnd = currencyService.CurrencyConversion(usd);
        model.addAttribute("vnd",vnd);
        return "show";
    }
}
