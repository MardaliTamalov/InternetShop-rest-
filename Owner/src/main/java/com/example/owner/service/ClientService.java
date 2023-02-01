package com.example.owner.service;

import com.example.owner.dto.ClientDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClientService {
    
    void addClient(UserDetails userDetails, ClientDto clientDto);
}
