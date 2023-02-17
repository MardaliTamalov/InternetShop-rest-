package com.example.order.service;

import com.example.order.dto.OrderDto;
import com.example.order.dto.ResponseDto;

public interface OrderService {
    ResponseDto makeOrder(OrderDto orderDto);

}
