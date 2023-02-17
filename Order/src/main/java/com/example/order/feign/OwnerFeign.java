package com.example.order.feign;

import com.example.order.dto.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "Owner")

public interface OwnerFeign {

    @GetMapping("/account")
    AccountDto getAccountDto();

    @PutMapping("/account")
    void reduceAmount(Double amount);


}
