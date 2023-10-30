package com.deviot.agripurebackend.profile.domain.services;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;


import java.util.List;

public interface IProfileCommandService {
    String handle(CreateProfileCommand createProfileCommand);
    List<Profile> handle();
    String handle(DeleteProfileCommand deleteProfileCommand);

    void  deleteProfileByUserId(Long userId);
}
