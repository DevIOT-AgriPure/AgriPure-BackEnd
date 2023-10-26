package com.deviot.agripurebackend.IoTManagement.domain.services.command;

import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.AssignDevicetoCropCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.CreateDeviceCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.device.DeleteDeviceCommand;

public interface IDeviceCommandService {
    Long handle(CreateDeviceCommand createDeviceCommand);
    Long handle(AssignDevicetoCropCommand assignDevicetoCropCommand);
    Long handle(DeleteDeviceCommand deleteDeviceCommand);
}
