package com.example.owner.service.impl;

import com.example.owner.dto.ClientDto;
import com.example.owner.entity.Client;
import com.example.owner.repository.ClientRepository;
import com.example.owner.repository.UserRepository;
import com.example.owner.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final UserRepository userRepository;

    @Override
    public void addClient(UserDetails userDetails, ClientDto clientDto) {
        Client client= new Client();

   client.setName(clientDto.getName());
   client.setSurname(clientDto.getSurname());
   client.setUser(userRepository.getUsersByLogin(userDetails.getUsername()));

        clientRepository.save(client);
    }
}
