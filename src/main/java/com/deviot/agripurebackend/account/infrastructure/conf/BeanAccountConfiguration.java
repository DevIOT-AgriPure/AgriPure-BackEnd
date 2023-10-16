package com.deviot.agripurebackend.account.infrastructure.conf;


import com.deviot.agripurebackend.account.application.services.AccountService;
import com.deviot.agripurebackend.account.domain.repository.AccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanAccountConfiguration {
    @Bean
    AccountService accountBeanService(final AccountRepository accountRepository){
        return new AccountService(accountRepository);
    }
}
