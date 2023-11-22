package com.deviot.agripurebackend.IoTManagement.domain.service.queryService;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.*;

import com.deviot.agripurebackend.IoTManagement.interfaces.DTOs.TemperatureAndHumidity;

import java.util.List;

public interface IDeviceQueryService {
    List<Device> handle(GetDevicesByCropIdQuery getDevicesByCropIdQuery);
    Device handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);


    List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query);

    List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery);

}
