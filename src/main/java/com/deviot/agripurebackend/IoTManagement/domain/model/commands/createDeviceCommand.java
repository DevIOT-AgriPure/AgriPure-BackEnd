package com.deviot.agripurebackend.IoTManagement.domain.model.commands;

public record createDeviceCommand(String name,String model,String category,String cropName,Long cropId,Long farmerId,Long projectId) {

}
