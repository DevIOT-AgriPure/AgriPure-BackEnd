package com.deviot.agripurebackend.IoTManagement.domain.model.commands;

public record SetRealTimeDataCommand(Long deviceId,boolean newStatus) {
}
