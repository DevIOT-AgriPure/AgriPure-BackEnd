package com.deviot.agripurebackend.account.application.services;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.infrastructure.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public boolean CreateUserAccount(CreateAccountCommand command){
        if(accountRepository.findByEmail(command.getEmail())==null){
            account newAccount=new account(0L,command.getEmail(),command.getPassword());
            accountRepository.save(newAccount);
            return true;
        }
        return false;
    }
}
