package com.deviot.agripurebackend.account.domain.services;

import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;

public interface AccountCommandService {

    Long handle(CreateAccountCommand createAccountCommand);
    Long handle(LogInCommand logInCommand);
}
