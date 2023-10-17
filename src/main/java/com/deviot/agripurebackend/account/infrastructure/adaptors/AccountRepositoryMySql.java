package com.deviot.agripurebackend.account.infrastructure.adaptors;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.domain.repository.AccountRepository;
import com.deviot.agripurebackend.account.infrastructure.entity.accountEntity;
import com.deviot.agripurebackend.account.infrastructure.rest.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AccountRepositoryMySql implements AccountRepository {

    private final AccountCrudRepository accountCrudRepository;
    @Autowired
    private AccountMapper accountMapper;

    public AccountRepositoryMySql(AccountCrudRepository accountCrudRepository) {
        this.accountCrudRepository = accountCrudRepository;
    }

    @Override
    public List<account> findAll() {
        return this.accountMapper.toAccounts(this.accountCrudRepository.findAll());
    }

    @Override
    public account save(CreateAccountCommand createAccountCommand) {
        account newAccount=new account(createAccountCommand.getEmail(), createAccountCommand.getPassword());
        accountEntity accountEntity=this.accountMapper.toAccountEntity(newAccount);
        System.out.println("Code: "+accountEntity.getId());
        return this.accountMapper.toAccount(this.accountCrudRepository.save(accountEntity));
    }

    @Override
    public Optional<account> findByEmailAndPassword(CreateAccountCommand createAccountCommand) {
        accountEntity account=this.accountCrudRepository.findByEmailAndPassword(createAccountCommand.getEmail(), createAccountCommand.getPassword());
        return Optional.of(this.accountMapper.toAccount(account));

    }

    @Override
    public void deleteById(Long id) {
        this.accountCrudRepository.deleteById(id);
    }
}
