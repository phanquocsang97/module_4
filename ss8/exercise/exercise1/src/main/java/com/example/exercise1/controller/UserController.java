package com.example.exercise1.controller;

import com.example.exercise1.model.User;
import com.example.exercise1.model.UserDto;
import com.example.exercise1.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0",required = false) int page,
                           Model model) {
        Pageable pageable = PageRequest.of(page,2);
        Page<User> userPage = userService.findAll(pageable);
        model.addAttribute("userPage",userPage);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("userDto",new UserDto());
        return "create";
    }
    @PostMapping("/create")
    public String saveInfo(@Valid @ModelAttribute UserDto userDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("mess","Created Success!!");
        return "redirect:/user";
    }
}
