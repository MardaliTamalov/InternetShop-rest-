package com.example.product.service.impl;

import com.example.product.dto.ProductDto;
import com.example.product.entity.Product;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.mapper.ProductMapper;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductDto(String name) {
        return productMapper.getProductDto(productRepository.findByName(name)
                .orElseThrow(()-> new ProductNotFoundException("Нет товара")));
    }

    @Override
    public void reduceAmountProduct(String name, Integer count) {
       Product product = productRepository.findProductByName(name);

       product.setCount(product.getCount()-count);


    }
}
