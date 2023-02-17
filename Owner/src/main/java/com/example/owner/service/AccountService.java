package com.example.owner.service;

import com.example.owner.dto.AccountDto;
import com.example.owner.dto.AccountDtoNumberAmount;
import org.springframework.security.core.userdetails.UserDetails;

public interface AccountService {
void addAccount(UserDetails userDetails, AccountDto accountDto);

AccountDtoNumberAmount getAccount();

void reduceAmount();

void reduceAmountSell(Double amount);
}
