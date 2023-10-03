package com.fastcampus.helloecommeradmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping(value = {"/products", "/products/"})
    public String index() {
        return "/products/products";
    }
    @GetMapping(value = "/products/{categoryId}")
    public String list(@RequestParam Long categoryId, Model model) {

        List<ProductDTO> productDTOList = new ArrayList<>();
        for (int i = 0; i < 20; i++) { }

        model.addAttribute("products", productDTOList);
        return "/products/products";
    }
    @GetMapping("/products/product-detail")
    public String detail(@RequestParam Long productId, Model model) { }
}
