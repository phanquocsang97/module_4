package com.example.exercise2.controller;

import com.example.exercise2.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping("/showWord")
    public String show(){
        return "show";
    }
    @PostMapping("/result")
    public String result(String english, Model model){
        String vietnamese = dictionaryService.Translate(english);
        if (vietnamese == null){
            model.addAttribute("message","Not in the dictionary");
        }else {
            model.addAttribute("vietnamese",vietnamese);
        }
        return "show";
    }
}
