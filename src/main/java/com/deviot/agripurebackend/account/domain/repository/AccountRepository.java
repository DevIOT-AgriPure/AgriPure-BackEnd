package com.deviot.agripurebackend.account.domain.repository;

import com.deviot.agripurebackend.account.domain.entities.account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository  extends JpaRepository<account,Long> {
    Optional<account> findByEmailAndPassword(String email, String password);
}
