package com.deviot.agripurebackend.IoTManagement.domain.model.commands;

public record SetTemperatureCommand(Long deviceId,Double temperature) {
}
