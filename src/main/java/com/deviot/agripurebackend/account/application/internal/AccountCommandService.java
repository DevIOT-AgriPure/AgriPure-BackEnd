package com.deviot.agripurebackend.account.application.internal;

import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import org.springframework.stereotype.Service;

@Service
public class AccountCommandService implements com.deviot.agripurebackend.account.domain.services.AccountCommandService {

    @Override
    public Long handle(CreateAccountCommand createAccountCommand) {
        return null;
    }

    @Override
    public Long handle(LogInCommand logInCommand) {
        return null;
    }
}
