package com.deviot.agripurebackend.account.infrastructure.repositories;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {

    Account findByEmail(String email);
}
