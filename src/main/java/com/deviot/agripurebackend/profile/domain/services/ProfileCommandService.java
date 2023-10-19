package com.deviot.agripurebackend.profile.domain.services;

import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.infrastructure.dtos.AuthResponse;

public interface ProfileCommandService {

    AuthResponse handle(CreateProfileCommand createAccountCommand);
}