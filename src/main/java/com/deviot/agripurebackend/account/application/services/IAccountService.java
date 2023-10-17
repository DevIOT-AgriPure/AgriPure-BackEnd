package com.deviot.agripurebackend.account.application.services;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;

import java.util.List;

public interface IAccountService {

    List<account> getAccounts();

    account getAccountByEmailAndPassword(CreateAccountCommand createAccountCommand);

    account saveAccount(CreateAccountCommand createAccountCommand);

    void deleteAccountById(Long id);
}
