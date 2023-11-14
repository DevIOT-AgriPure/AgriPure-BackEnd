package com.deviot.agripurebackend.IoTManagement.domain.service.CommandService;

import com.deviot.agripurebackend.IoTManagement.domain.model.commands.*;

public interface IDeviceCommandService {
    String handle(createDeviceCommand command);
    String handle(setActiveNotification command);
    String handle (setDeviceStatus command);
    String handle(SetRealTimeDataCommand command);

    Long handle(SetTemperatureCommand command);
    Long handle(AssignDeviceToCropCommand command);
}
