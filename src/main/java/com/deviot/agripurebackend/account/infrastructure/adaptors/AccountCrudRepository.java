package com.deviot.agripurebackend.account.infrastructure.adaptors;

import com.deviot.agripurebackend.account.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.infrastructure.entity.accountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountCrudRepository extends JpaRepository<accountEntity,Long> {
    accountEntity findByEmailAndPassword(String email, String password);
}
