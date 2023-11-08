package com.deviot.agripurebackend.IoTManagement.domain.service.CommandService;

import com.deviot.agripurebackend.IoTManagement.domain.model.commands.SetRealTimeDataCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.createDeviceCommand;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.setActiveNotification;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.setDeviceStatus;

public interface IDeviceCommandService {
    String handle(createDeviceCommand command);
    String handle(setActiveNotification command);
    String handle (setDeviceStatus command);
    String handle(SetRealTimeDataCommand command);
}
