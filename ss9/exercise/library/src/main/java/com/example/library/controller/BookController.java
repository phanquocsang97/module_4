package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.model.Customer;
import com.example.library.model.OrderDetail;
import com.example.library.service.*;
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

import java.util.List;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IOrderDetailService orderDetailService;
    @GetMapping("")
    public String showListBook(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Book> bookPage = bookService.findAll(pageable, searchName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("bookPage", bookPage);
        return "list";
    }
    @GetMapping("/rent/{id}")
    public String showRentBook(@PathVariable int id,
                               Model model) {
        Book book = bookService.findById(id);
        List<Customer> customers = customerService.findAll();
        int code = orderDetailService.generateRandomCode();
        model.addAttribute("code", code);
        model.addAttribute("customers", customers);
        model.addAttribute("book", book);
        return "rent";
    }
    @PostMapping("/rent")
    public String rentBook(RedirectAttributes redirectAttributes,
                           Book book,
                           @RequestParam int customerId,
                           @RequestParam String code) {
        book = bookService.rentBook(book.getBookId());
        if (book != null){
            orderDetailService.saveOrderDetail(book.getBookId(), Integer.parseInt(code),customerId);
            bookService.update(book, book.getBookId());
        }
        redirectAttributes.addFlashAttribute("message","rent success!!");
        return "redirect:/library";
    }

    @GetMapping("/history")
    public String rentHistory(Model model,
                              @RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.by("book_id").ascending());
        Page<OrderDetail> orderDetails = orderDetailService.findAll(pageable);
        model.addAttribute("orderDetail", orderDetails);
        return "history";
    }

    @GetMapping("/payBack")
    public String showPayBookBack() {
        return "rollback";
    }

    @PostMapping("/payBack")
    public String payBookBack(@RequestParam int code,
                              RedirectAttributes redirectAttributes,
                              Model model,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "rollback";
        }
        OrderDetail orderDetail = orderDetailService.findByCode(code);
        if (orderDetail != null) {
            int id = orderDetail.getOrderId();
            orderDetailService.deleteOrder(id);
            bookService.payBook(orderDetail.getBook().getBookId());
            redirectAttributes.addFlashAttribute("message", "Pay back successfully");
            return "redirect:/library";
        }
        model.addAttribute("code", code);
        model.addAttribute("message", "Code not found");
        return "rollback";

    }
}
