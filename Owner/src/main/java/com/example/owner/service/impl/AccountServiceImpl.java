package com.example.owner.service.impl;

import com.example.owner.dto.AccountDto;
import com.example.owner.entity.Account;
import com.example.owner.repository.AccountRepository;
import com.example.owner.repository.UserRepository;
import com.example.owner.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository ;
    private final UserRepository userRepository;
    @Override
    public void addAccount(UserDetails userDetails, AccountDto accountDto) {
        Account account =new Account();
        account.setAmount(accountDto.getAmount());
        account.setNumber(accountDto.getNumber());
        account.setUser(userRepository.getUsersByLogin(userDetails.getUsername()));

        accountRepository.save(account);
    }
}
