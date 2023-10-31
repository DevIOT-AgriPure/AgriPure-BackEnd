package com.deviot.agripurebackend.account.interfaces.rest;

import com.deviot.agripurebackend.account.application.internal.AccountCommandService;
import com.deviot.agripurebackend.account.application.internal.QueryService.AccountQueryService;
import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.model.commands.LogInCommand;
import com.deviot.agripurebackend.account.domain.model.queries.GetAccountByEmailQuery;
import com.deviot.agripurebackend.account.infrastructure.dtos.AuthResponse;
import com.deviot.agripurebackend.account.interfaces.rest.dto.CreateUserAccount;
import com.deviot.agripurebackend.profile.application.internal.ProfileCommandService;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;
    private final ProfileCommandService profileCommandService;

    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> logIn(@RequestBody LogInCommand logInCommand){
        return ResponseEntity.ok(this.accountCommandService.handle(logInCommand));
    }

    @PostMapping(value="register")
    public ResponseEntity<?> register(@RequestBody CreateUserAccount createUserAccount){

        CreateAccountCommand createAccountCommand=new CreateAccountCommand(createUserAccount.getEmail(),createUserAccount.getPassword(),createUserAccount.getType());

        this.accountCommandService.handle(createAccountCommand);

        GetAccountByEmailQuery getAccountByEmailQuery=new GetAccountByEmailQuery(createAccountCommand.email());

        Account account=this.accountQueryService.handle(getAccountByEmailQuery);

        CreateProfileCommand createProfileCommand=new CreateProfileCommand(
                account.getId().longValue(),
                createUserAccount.getName(),
                createUserAccount.getDescription(),
                createUserAccount.getImageUrl(),
                createUserAccount.getLocation(),
                createUserAccount.getPlanId());
        String message=this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok(message);
    }
}
