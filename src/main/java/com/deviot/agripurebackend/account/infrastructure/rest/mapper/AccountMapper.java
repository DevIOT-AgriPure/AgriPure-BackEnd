package com.deviot.agripurebackend.account.infrastructure.rest.mapper;


import com.deviot.agripurebackend.account.domain.entities.account;
import com.deviot.agripurebackend.account.infrastructure.entity.accountEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;


@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "password", target = "password")

    }
    )
    account toAccount(accountEntity account);
    List<account> toAccounts(List<accountEntity> accountEntity);

    @InheritInverseConfiguration
    accountEntity toAccountEntity (account accountt);

}
