package com.deviot.agripurebackend.crop.domain.services;

import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;

public interface ICropRepositoryCommandService {
    String handle(AddCropReportCommand addCropReportCommand);
    String handle(DeleteCropReportCommand deleteCropReportCommand);
}
