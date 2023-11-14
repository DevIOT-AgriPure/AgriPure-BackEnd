package com.deviot.agripurebackend.IoTManagement.domain.model.commands;

public record setDeviceStatus(Long deviceId,boolean newStatus) {
}
