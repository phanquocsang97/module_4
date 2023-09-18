package com.example.exercise1.controller;

import com.example.exercise1.model.Settings;
import com.example.exercise1.service.ISettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SettingsController {
    @Autowired
    private ISettingsService settingsService;
    @ModelAttribute("languages")
    public String[] getLanguages(){
        return new String[]{"English","Vietnamese","Japanese","Chinese"};
    }
    @ModelAttribute("pageSize")
    public int[] getPageSize(){
        return new int[]{5,10,15,20};
    }

    @GetMapping("/showList")
    public String show(Model model) {
        model.addAttribute("settings",settingsService.getSettings());
        return "display";
    }
    @GetMapping("/create")
    public String showForm(Model model){
        model.addAttribute("settings",settingsService.getSettings());
        return "settings";
    }
    @PostMapping("/create")
    public String save(@ModelAttribute Settings settings,
                       RedirectAttributes redirectAttributes){
        settingsService.update(settings);
        redirectAttributes.addFlashAttribute("mess","create success");
        return "redirect:/create";

    }

}
