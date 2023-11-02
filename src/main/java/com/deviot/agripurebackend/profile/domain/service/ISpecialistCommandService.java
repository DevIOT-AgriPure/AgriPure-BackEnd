package com.deviot.agripurebackend.profile.domain.service;

import com.deviot.agripurebackend.profile.domain.model.commands.specialist.CreateSpecialistCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.specialist.DeleteSpecialistCommand;

public interface ISpecialistCommandService {
    String handle(CreateSpecialistCommand createSpecialistCommand);
    String handle(DeleteSpecialistCommand deleteSpecialistCommand);
}
