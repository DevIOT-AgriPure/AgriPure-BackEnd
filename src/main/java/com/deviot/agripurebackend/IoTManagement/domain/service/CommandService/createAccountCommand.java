package com.deviot.agripurebackend.IoTManagement.domain.service.CommandService;

public record createAccountCommand(String name,String model,String category,String cropName,Long farmerId,Long projectId) {

}
