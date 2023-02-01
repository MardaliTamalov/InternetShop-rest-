package com.example.owner.controller;

import com.example.owner.dto.AccountDto;
import com.example.owner.dto.ClientDto;
import com.example.owner.service.AccountService;
import com.example.owner.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor

public class AccountController {
    private final AccountService accountService;

    @PostMapping("add-account")
    public ResponseEntity<?> addClient(UserDetails userDetails, @RequestBody AccountDto accountDto) {
        accountService.addAccount(userDetails,accountDto);
        return ResponseEntity.ok().build();
    }}
