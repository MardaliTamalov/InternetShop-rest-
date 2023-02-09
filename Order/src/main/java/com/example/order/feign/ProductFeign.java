package com.example.order.feign;

import com.example.order.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Product")

public interface ProductFeign {

    @GetMapping("/product/{name}")
    ProductDto getProductDto(@PathVariable String name);
}
