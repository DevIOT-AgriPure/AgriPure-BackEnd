package com.deviot.agripurebackend.IoTManagement.domain.model.commands;

public record setActiveNotification(Long deviceId,boolean newStatus) {
}
