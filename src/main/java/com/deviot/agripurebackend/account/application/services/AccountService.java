package com.deviot.agripurebackend.account.application.services;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.domain.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<account> getAccounts(){
        return this.accountRepository.findAll();
    }

    public account getAccount(CreateAccountCommand createAccountCommand){
        Optional<account> present_account = this.accountRepository.findByEmailAndPassword(createAccountCommand.getEmail(), createAccountCommand.getPassword());
        if(present_account.isPresent()){
            return present_account.get();
        }
        else{
            return null;
        }
    }

    public account createAccount(CreateAccountCommand createAccountCommand){
        account newAccount=new account(createAccountCommand.getEmail(), createAccountCommand.getPassword());
        return this.accountRepository.save(newAccount);
    }

    public void deleteAccount(Long id){
        this.accountRepository.deleteById(id);
    }
}
