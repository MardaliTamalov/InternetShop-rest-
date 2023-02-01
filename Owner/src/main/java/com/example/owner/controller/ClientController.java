package com.example.owner.controller;

import com.example.owner.dto.ClientDto;
import com.example.owner.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor

public class ClientController {
    private final ClientService clientService;

    @PostMapping("add-client")
    public ResponseEntity<?> addClient(UserDetails userDetails, @RequestBody ClientDto clientDto) {
        clientService.addClient(userDetails, clientDto);
        return ResponseEntity.ok().build();
    }}
