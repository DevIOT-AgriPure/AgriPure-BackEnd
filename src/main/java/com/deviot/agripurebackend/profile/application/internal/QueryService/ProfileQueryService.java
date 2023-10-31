package com.deviot.agripurebackend.profile.application.internal.QueryService;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileBySpecialistId;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByUserId;
import com.deviot.agripurebackend.profile.domain.services.queryService.IProfileQueryService;
import com.deviot.agripurebackend.profile.infrastructure.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileQueryService implements IProfileQueryService {

    private final ProfileRepository profileRepository;

    @Override
    public List<Profile> handle(GetProfileBySpecialistId getProfileBySpecialistId) {
        List<Profile> profile = profileRepository.findProfileBySpecialistId(getProfileBySpecialistId.specialistId());
        return profile;
    }

    @Override
    public List<Profile> handle(GetProfileByUserId getProfileByUserId) {
        List<Profile> profile = profileRepository.findProfileByUserId(getProfileByUserId.userId());
        return profile;
    }
    
}
