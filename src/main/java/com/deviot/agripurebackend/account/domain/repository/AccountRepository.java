package com.deviot.agripurebackend.account.domain.repository;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository {

    List<account> findAll();


    account save(CreateAccountCommand createAccountCommand);
    Optional<account> findByEmailAndPassword(CreateAccountCommand createAccountCommand);

    void deleteById(Long id);
}
