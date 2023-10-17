package com.deviot.agripurebackend.profile.domain.repository;

import com.deviot.agripurebackend.profile.domain.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.entities.profile;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository {

    List<profile> findAll();


    profile save(CreateProfileCommand createProfileCommand);

    Optional<profile> findByEmailAndPassword(CreateProfileCommand createProfilecommand);

    void deleteById(Long id);
}
