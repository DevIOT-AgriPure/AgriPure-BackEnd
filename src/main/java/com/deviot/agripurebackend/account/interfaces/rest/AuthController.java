package com.deviot.agripurebackend.account.interfaces.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    @PostMapping(value = "login")
    public String logIn(){
        return "Login form";
    }

    @PostMapping(value="register")
    public String register(){
        return "Register form";
    }
}
