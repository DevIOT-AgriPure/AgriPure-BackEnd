package com.deviot.agripurebackend.account.infrastructure;
import com.deviot.agripurebackend.account.domain.entities.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<account,Long> {

}
