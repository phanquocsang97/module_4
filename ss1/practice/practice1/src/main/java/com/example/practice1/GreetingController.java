package com.example.practice1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model){
        name =  "sang";
        model.addAttribute("name",name);
        return "index";
    }

    @PostMapping("/studen/create")
    public String show(){
        return "create";
    }
}
