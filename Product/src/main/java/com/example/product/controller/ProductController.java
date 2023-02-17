package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("/product/{name}")
    public ProductDto getProductDto(@PathVariable String name){
     return productService.getProductDto(name);
    }

    @PutMapping("/product")
    public void reduceCountProduct(@RequestParam String name, Integer count){
        productService.reduceAmountProduct(name, count);
        }

}
