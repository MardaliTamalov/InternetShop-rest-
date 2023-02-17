package com.example.owner.mapper;

import com.example.owner.dto.AccountDtoNumberAmount;
import com.example.owner.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface AccountMapper {

    AccountDtoNumberAmount getAccountDto(Account account);
}
