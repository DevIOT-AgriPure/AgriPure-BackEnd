package com.deviot.agripurebackend.IoTManagement.application.internal.device.CommandService;

import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.AssignDevicetoCropCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.CreateDeviceCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.DeleteDeviceCommand;
import com.deviot.agripurebackend.IoTManagement.domain.services.command.IDeviceCommandService;
import com.deviot.agripurebackend.IoTManagement.infrastructure.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeviceCommandService implements IDeviceCommandService {
    private final DeviceRepository deviceRepository;
    @Override
    public Long handle(CreateDeviceCommand createDeviceCommand) {
        return null;
    }

    @Override
    public Long handle(AssignDevicetoCropCommand assignDevicetoCropCommand) {
        return null;
    }

    @Override
    public Long handle(DeleteDeviceCommand deleteDeviceCommand) {
        return null;
    }
}
