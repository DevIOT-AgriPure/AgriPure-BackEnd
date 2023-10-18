package com.deviot.agripurebackend.account.application.internal;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import com.deviot.agripurebackend.account.infrastructure.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountCommandService implements com.deviot.agripurebackend.account.domain.services.AccountCommandService {

    private final AccountRepository accountRepository;

    public AccountCommandService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Long handle(CreateAccountCommand createAccountCommand) {
        Account account=new Account(createAccountCommand.email(),createAccountCommand.password());
        this.accountRepository.save(account);
        return 1L;
    }

    @Override
    public Long handle(LogInCommand logInCommand) {

        Account logAccount=this.accountRepository.findByEmail(logInCommand.email());
        if(logAccount!=null){
            if(Objects.equals(logAccount.getPassword(), logInCommand.password())){
                return logAccount.getId();
            }

            return 0L;
        }
        else {
            return 0L;
        }
    }
}
