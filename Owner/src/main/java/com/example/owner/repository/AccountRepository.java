package com.example.owner.repository;

import com.example.owner.entity.Account;
import com.example.owner.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findAccountByUser(User user);
}
