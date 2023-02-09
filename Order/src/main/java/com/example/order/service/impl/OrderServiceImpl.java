package com.example.order.service.impl;

import com.example.order.dto.OrderDto;
import com.example.order.dto.ProductDto;
import com.example.order.dto.ResponseDto;
import com.example.order.feign.ProductFeign;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl  implements OrderService {
private final OrderRepository orderRepository;
private final ProductFeign productFeign;

    @Override
    public ResponseDto makeOrder(OrderDto orderDto) {


        ProductDto productDto = productFeign.getProductDto(orderDto.name());
        if(orderDto.count()>productDto.count()){
            return new ResponseDto(false, "на складе недостаточно товаров");
        }

        return null;
    }
}
