package com.example.exercise2.controller;

import com.example.exercise2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private ICalculatorService calculatorService;

    @GetMapping("/showCalculator")
    public String showForm() {
        return "result";
    }

    @RequestMapping("/showResult")
    public String calculate(@RequestParam double numFirst,
                            @RequestParam double numSecond,
                            @RequestParam String input,
                            Model model) {
            String totalCaculation = calculatorService.calculate(numFirst, numSecond, input);
            model.addAttribute("totalCaculation", totalCaculation);
        return "result";
    }
}
