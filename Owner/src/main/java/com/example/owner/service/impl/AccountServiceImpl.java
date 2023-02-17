package com.example.owner.service.impl;

import com.example.owner.dto.AccountDto;
import com.example.owner.dto.AccountDtoNumberAmount;
import com.example.owner.entity.Account;
import com.example.owner.entity.User;
import com.example.owner.mapper.AccountMapper;
import com.example.owner.repository.AccountRepository;
import com.example.owner.repository.UserRepository;
import com.example.owner.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final AccountMapper accountMapper;
    @Override
    public void addAccount(UserDetails userDetails, AccountDto accountDto) {
        Account account =new Account();
        account.setAmount(accountDto.getAmount());
        account.setNumber(accountDto.getNumber());
        account.setUser(userRepository.getUsersByLogin(userDetails.getUsername()));

        accountRepository.save(account);
    }

    @Override
    public AccountDtoNumberAmount getAccount() {
        User securityUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByLogin(securityUser.getLogin());

        return accountMapper.getAccountDto(accountRepository.findAccountByUser(user));
    }

    @Override
    public void reduceAmount() {
        User securityUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByLogin(securityUser.getLogin());
        accountRepository.delete(accountRepository.findAccountByUser(user));
    }

    @Override
    public void reduceAmountSell(Double amount) {
        User securityUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.getUsersByLogin(securityUser.getLogin());.
        Account account =  accountRepository.findAccountByUser(user);
        account.setAmount(account.getAmount() - amount);
    }
}
}
