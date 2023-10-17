package com.deviot.agripurebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.deviot.agripurebackend.account.domain.repository")
public class AgriPureBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgriPureBackendApplication.class, args);
	}

}
