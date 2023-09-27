package com.example.exercise1.controller;

import com.example.exercise1.dto.BookDto;
import com.example.exercise1.model.Book;
import com.example.exercise1.service.IBookService;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String nameSearch,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<Book> bookPage = bookService.findAll(pageable, nameSearch);
        model.addAttribute("bookPage", bookPage);
        return "home";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("bookDto", new BookDto());
        return "create-book";
    }

    @PostMapping("/create")
    public String saveFormCreate(@Valid @ModelAttribute BookDto bookDto,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create-book";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        bookService.addBook(book);
        redirectAttributes.addFlashAttribute("mess", "Created Success!!");
        return "redirect:/book";
    }
    @GetMapping("/detail/{id}")
    public String showDetailBook(@PathVariable int id,
                                 Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "detail-book";
    }
}
