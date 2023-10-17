package com.deviot.agripurebackend.account.infrastructure.repositories;

import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
