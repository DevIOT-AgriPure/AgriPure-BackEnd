package com.deviot.agripurebackend.profile.application.internal;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.services.IProfileCommandService;
import com.deviot.agripurebackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileCommandService implements IProfileCommandService {
    private final ProfileRepository profileRepository;
    @Override
    public String handle(CreateProfileCommand createProfileCommand) {
        Profile newProfile=Profile.builder()
                .userId(createProfileCommand.userId())
                .suscritionId(createProfileCommand.suscriptionId())
                .firstName(createProfileCommand.firstName())
                .lastName(createProfileCommand.lastName())
                .cellphone(createProfileCommand.cellphone())
                .build();
        if(profileRepository.save(newProfile)!=null){
            return "PROFILE REGISTERED!!!";
        }
        return "CAN'T REGISTER PROFILE";
    }
    @Override
    public List<Profile> handle() {
        return profileRepository.findAll();
    }

    @Override
    public String handle(DeleteProfileCommand deleteProfileCommand) {

        List<Profile> profiles = profileRepository.findProfileByUserId(deleteProfileCommand.userId());
        if (!profiles.isEmpty()){
            for (Profile profile: profiles){
                profileRepository.delete(profile);
            }
            return "Profile with id"+deleteProfileCommand.userId()+"was deleted";
        }
        return "Profile with id:"+ deleteProfileCommand.userId() +"doesnt exists";
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