package com.example.product.controller;

import com.example.product.dto.CartDto;
import com.example.product.dto.ProductDto;
import com.example.product.model.Product;
import com.example.product.service.IProductService;
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
@RequestMapping("/product")
@SessionAttributes("cart")
public class ProductController {
    @ModelAttribute("cart")
    public CartDto initCartDto() {
        return new CartDto();
    }

    @Autowired
    IProductService productService;

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable int id,
                            @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteToCart(@PathVariable int id,
                               @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.deleteProduct(productDto);
        }
        return "redirect:/cart";
    }

    @GetMapping("")
    public String showList(@RequestParam(defaultValue = "0", required = false) int page,
                           @RequestParam(defaultValue = "", required = false) String searchName,
                           Model model) {
        Pageable pageable = PageRequest.of(page, 3);
        Page<Product> productPage = productService.findAll(pageable, searchName);
        model.addAttribute("searchName", searchName);
        model.addAttribute("productPage", productPage);
        return "product/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "product/create";
    }

    @PostMapping("/create")
    public String saveInfo(@Valid @ModelAttribute ProductDto productDto,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
//        new SongDto().validate(productDto,bindingResult);
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        productService.create(product);
        redirectAttributes.addFlashAttribute("mess", "Created Success!!");
        return "redirect:/product";
    }

    @GetMapping("/minus/{id}")
    public String minus(@PathVariable int id,
                        @SessionAttribute(value = "cart", required = false) CartDto cartDto) {
        Product product = productService.findById(id);
        if (product != null) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(product, productDto);
            cartDto.minusProductQuantity(productDto);
        }
        return "redirect:/cart";
    }
}
