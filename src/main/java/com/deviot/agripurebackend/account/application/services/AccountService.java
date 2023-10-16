package com.deviot.agripurebackend.account.application.services;

import com.deviot.agripurebackend.account.infrastructure.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
