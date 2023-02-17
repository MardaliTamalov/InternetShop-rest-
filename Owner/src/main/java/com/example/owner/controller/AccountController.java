package com.example.owner.controller;

import com.example.owner.dto.AccountDto;
import com.example.owner.dto.AccountDtoNumberAmount;
import com.example.owner.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor

public class AccountController {
    private final AccountService accountService;

    @PostMapping("/account")
    public ResponseEntity<?> addClient(UserDetails userDetails, @RequestBody AccountDto accountDto) {
        accountService.addAccount(userDetails,accountDto);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/account")
public AccountDtoNumberAmount getAccount(){
        return accountService.getAccount();
    }

    @PutMapping("/account")
    public void reduceAmount(Double amount){
    accountService.reduceAmountSell(amount);
    }
}
