package com.deviot.agripurebackend.IoTManagement.domain.service.queryService;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetTemperaturesAndHumidityByCropIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;
import com.deviot.agripurebackend.IoTManagement.interfaces.DTOs.TemperatureAndHumidity;

import java.util.List;

public interface IDeviceQueryService {

    List<Double> handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);

    List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query);
}
