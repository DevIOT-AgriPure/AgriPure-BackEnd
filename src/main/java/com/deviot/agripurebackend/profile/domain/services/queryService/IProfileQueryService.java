package com.deviot.agripurebackend.profile.domain.services.queryService;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileBySpecialistId;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByUserId;

import java.util.List;

public interface IProfileQueryService {
    List<Profile> handle(GetProfileBySpecialistId getProfileBySpecialistId);
    List<Profile> handle(GetProfileByUserId getProfileByUserId);
}
