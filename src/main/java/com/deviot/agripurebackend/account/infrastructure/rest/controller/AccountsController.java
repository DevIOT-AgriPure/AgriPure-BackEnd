package com.deviot.agripurebackend.account.infrastructure.rest.controller;


import com.deviot.agripurebackend.account.application.services.AccountService;
import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/accounts")
public class AccountsController {

    private final AccountService accountService;

    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/allAccounts")
    public ResponseEntity<List<account>> getAccounts(){
        return new ResponseEntity<>(this.accountService.getAccounts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<account> createAccount(@RequestBody CreateAccountCommand createAccountCommand){

        return new ResponseEntity<>(this.accountService.saveAccount(createAccountCommand),HttpStatus.CREATED);
    }
}
