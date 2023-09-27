package com.example.exercise1.controller;

import com.example.exercise1.model.OrderDetail;
import com.example.exercise1.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Autowired
    IOrderDetailService orderDetailService;
    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String nameSearch,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<OrderDetail> orderDetailPage = orderDetailService.findAll(pageable, nameSearch);
        model.addAttribute("orderDetailPage", orderDetailPage);
        return "home";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("orderDetail", new OrderDetail());
        return "list-order";
    }

    @PostMapping("/create")
    public String saveFormCreate(@Valid @ModelAttribute OrderDetail orderDetail,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "list-order";
        }
        orderDetailService.addOrderDetail(orderDetail);
        redirectAttributes.addFlashAttribute("mess", "Created Success!!");
        return "redirect:/orderDetail";
    }
}
