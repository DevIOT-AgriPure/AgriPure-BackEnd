package com.deviot.agripurebackend.profile.domain.repository;

import com.deviot.agripurebackend.profile.domain.commands.CreateAccountCommand;
import com.deviot.agripurebackend.profile.domain.entities.profile;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository {

    List<profile> findAll();


    profile save(CreateAccountCommand createAccountCommand);
    Optional<profile> findByEmailAndPassword(CreateAccountCommand createAccountCommand);

    void deleteById(Long id);
