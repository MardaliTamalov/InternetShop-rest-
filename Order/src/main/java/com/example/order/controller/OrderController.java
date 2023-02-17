package com.example.order.controller;

import com.example.order.dto.OrderDto;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {
    private final OrderService orderService;
    @PostMapping("/orders")
    public ResponseEntity<?> makeOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.status(HttpStatus.OK)
                .body(orderService.makeOrder(orderDto));
    }
}
