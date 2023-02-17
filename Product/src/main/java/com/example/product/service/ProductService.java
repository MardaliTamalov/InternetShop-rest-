package com.example.product.service;

import com.example.product.dto.ProductDto;

public interface ProductService {

ProductDto getProductDto(String name);

void reduceAmountProduct(String name, Integer count);
}
