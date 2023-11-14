package com.deviot.agripurebackend.IoTManagement.interfaces.DTOs;

import lombok.Data;

@Data
public class TemperatureAndHumidity {
    private Long deviceId;
    private Double temperature;
    private Double humidity;
}
