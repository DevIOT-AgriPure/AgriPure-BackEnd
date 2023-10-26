package com.deviot.agripurebackend.IoTManagement.domain.model.commands.device;

public record CreateDeviceCommand(Long farmerId,Long deviceCatalogId) {
}
