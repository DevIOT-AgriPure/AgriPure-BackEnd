package com.deviot.agripurebackend.devices.domain.service.queryService;

import com.deviot.agripurebackend.devices.domain.model.aggregate.Device;
import com.deviot.agripurebackend.devices.domain.model.queries.GetDeviceByIdQuery;

import com.deviot.agripurebackend.devices.domain.model.queries.GetTemperaturesAndHumidityByCropIdQuery;

import com.deviot.agripurebackend.devices.domain.model.queries.GetDevicesByFarmerIdQuery;
import com.deviot.agripurebackend.devices.domain.model.queries.getTemperatureQuery;
import com.deviot.agripurebackend.devices.interfaces.DTOs.TemperatureAndHumidity;

import java.util.List;

public interface IDeviceQueryService {

    Device handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);


    List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query);

    List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery);

}
