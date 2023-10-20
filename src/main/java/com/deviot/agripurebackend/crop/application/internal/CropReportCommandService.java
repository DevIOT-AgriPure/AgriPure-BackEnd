package com.deviot.agripurebackend.crop.application.internal;

import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;
import com.deviot.agripurebackend.crop.domain.services.ICropRepositoryCommandService;

public class CropReportCommandService implements ICropRepositoryCommandService {
    @Override
    public String handle(AddCropReportCommand addCropReportCommand) {
        return null;
    }

    @Override
    public String handle(DeleteCropReportCommand deleteCropReportCommand) {
        return null;
    }
}
