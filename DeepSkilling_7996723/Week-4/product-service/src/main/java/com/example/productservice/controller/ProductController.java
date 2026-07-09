package com.example.productservice.controller;

import com.example.productservice.entity.Product;
import com.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping
    public Product save(
            @RequestBody Product product) {
        return service.save(product);
    }
}