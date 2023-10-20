package com.deviot.agripurebackend.crop.application.internal;

import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;
import com.deviot.agripurebackend.crop.domain.services.ICropCommandService;

public class CropCommandService implements ICropCommandService {
    @Override
    public String handle(CreateCropCommand createCropCommand) {
        return null;
    }

    @Override
    public String handle(AddCropReportCommand addCropReportCommand) {
        return null;
    }

    @Override
    public String handle(DeleteCropCommand deleteCropCommand) {
        return null;
    }

    @Override
    public String handle(DeleteCropReportCommand deleteCropReportCommand) {
        return null;
    }
}
