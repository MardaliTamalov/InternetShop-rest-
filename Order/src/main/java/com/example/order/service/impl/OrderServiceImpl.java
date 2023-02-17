package com.example.order.service.impl;

import com.example.order.dto.AccountDto;
import com.example.order.dto.OrderDto;
import com.example.order.dto.ProductDto;
import com.example.order.dto.ResponseDto;
import com.example.order.entity.Order;
import com.example.order.feign.OwnerFeign;
import com.example.order.feign.ProductFeign;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor

public class OrderServiceImpl  implements OrderService {
private final OrderRepository orderRepository;
private final ProductFeign productFeign;
private final OwnerFeign ownerFeign;
    @Override
    public ResponseDto makeOrder(OrderDto orderDto) {
        ProductDto productDto = productFeign.getProductDto(orderDto.name());
        AccountDto accountDto = ownerFeign.getAccountDto();
        if(accountDto.amount() < (orderDto.count()*productDto.price()))
            return new ResponseDto(false,"Недостаточно денежных средст");

        if(orderDto.count()>productDto.count())
            return new ResponseDto(false, "на складе недостаточно товаров");

        productFeign.reduceCountProduct(orderDto.name(), orderDto.count());
        ownerFeign.reduceAmount(productDto.price() * productDto.count());

        Order order= new Order();
        order.setData(LocalDate.now());
        order.setCount(orderDto.count());
        order.setProducts(orderDto.name());

        orderRepository.save(order);
        return null;
    }
}
