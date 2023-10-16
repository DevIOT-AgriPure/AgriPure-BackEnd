package com.deviot.agripurebackend.account.domain.commands;

import lombok.Getter;

@Getter
public class CreateAccountCommand {
    String email;
    String password;
    public CreateAccountCommand(String email,String password){
        this.email=email;
        this.password=password;
    }
}
