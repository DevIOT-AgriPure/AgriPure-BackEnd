package com.deviot.agripurebackend.profile.application.internal;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.services.IProfileCommandService;
import com.deviot.agripurebackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import javax.management.Notification;

@Service
@RequiredArgsConstructor
public interface ProfileCommandService extends IProfileCommandService {

    private final ProfileRepository profileRepository;
    @Override
    public String handle(CreateProfileCommand createProfileCommand) {
        Profile newProfile=Profile.builder()
                .userId(createProfileCommand.userId())
                .suscriptionId(createProfileCommand.suscriptionId())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        if(profileRepository.save(newProfile)!=null){
            return "CROP REGISTERED!!!";
        }
        return "CAN'T REGISTER YOUR CROP";
    }
    @Override
    public List<Profile> handle() {
        return profileRepository.findAll();
    }

    @Override
    public String handle(DeleteProfileCommand deleteProfileCommand) {

        List<Profile> profiles = profileRepository.findProfileByUserId(deleteProfileCommand.id());
        if (!profiles.isEmpty()){
            for (Profile profile: profiles){
                profileRepository.delete(profile);
            }
            return "Profile with id"+deleteProfileCommand.id()+"was deleted";
        }
        return "Profile with id:"+ deleteProfileCommand.id()+"doesnt exists";
    }

    @Override
    public void deleteProfileByUserId(Long userId) {
        List<Profile> profiles = profileRepository.findProfileByUserId(userId);
        if (!profiles.isEmpty()){
            for (Profile profile: profiles){
                profileRepository.delete(profile);
            }
        }
    }

}