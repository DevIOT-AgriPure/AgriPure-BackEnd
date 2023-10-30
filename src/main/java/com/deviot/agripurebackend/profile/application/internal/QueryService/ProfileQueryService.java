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

import javax.management.Notification;

@Service
@RequiredArgsConstructor

public class ProfileQueryService implements IProfileQueryService {

        private final ProfileRepository notificationRepository;

    @Override
    public List<Profile> handle(GetProfileBySpecialistId getNotificationsBySpecialistId) {
        List<Notification> notifications = notificationRepository.findProfileBySpecialistId(getProfileBySpecialistId.specialistId());
        return profile;
    }

    @Override
    public List<Profile> handle(GetProfileByUserId getNotificationsByUserId) {
        List<Notification> notification = notificationRepository.findProfileByUserId(getProfileByUserId.userId());
        return profile;
    }
    
}
