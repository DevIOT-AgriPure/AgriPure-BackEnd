package com.deviot.agripurebackend.account.application.services;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements  IAccountService{

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<account> getAccounts() {
        return this.accountRepository.findAll();
    }

    @Override
    public account getAccountByEmailAndPassword(CreateAccountCommand createAccountCommand) {
        Optional<account> presentAccount = this.accountRepository.findByEmailAndPassword(createAccountCommand);
        if(presentAccount.isPresent()){
            return presentAccount.get();
        }
        return null;
    }

    @Override
    public account saveAccount(CreateAccountCommand createAccountCommand) {
        return this.accountRepository.save(createAccountCommand);
    }

    @Override
    public void deleteAccountById(Long id) {
        this.accountRepository.deleteById(id);
    }
}
