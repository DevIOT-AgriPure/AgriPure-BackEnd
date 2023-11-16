package com.deviot.agripurebackend.IoTManagement.application.internal;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;

import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetTemperaturesAndHumidityByCropIdQuery;

import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDevicesByFarmerIdQuery;

import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;
import com.deviot.agripurebackend.IoTManagement.domain.service.queryService.IDeviceQueryService;
import com.deviot.agripurebackend.IoTManagement.interfaces.DTOs.TemperatureAndHumidity;
import com.deviot.agripurebackend.IoTManagement.infrastructure.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceQueryService implements IDeviceQueryService {
    private final DeviceRepository deviceRepository;

    @Override
    public Device handle(getTemperatureQuery query) {
        Optional<Device> device=deviceRepository.findById(query.deviceId());
        return device.get();
    }

    @Override
    public Device handle(GetDeviceByIdQuery query) {
        Optional<Device> device=deviceRepository.findById(query.deviceId());
        return device.get();
    }

    @Override

    public List<TemperatureAndHumidity> handle(GetTemperaturesAndHumidityByCropIdQuery query) {
        List<Device> devices=deviceRepository.findDevicesByCropId(query.cropId());
        return devices.stream().map(device->{
            TemperatureAndHumidity data=new TemperatureAndHumidity();
            data.setDeviceId(device.getId());
            data.setTemperature(device.getPlanTemperature());
            data.setHumidity(device.getPlanHumidity());
            return data;
        }).collect(Collectors.toList());


    public List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery) {
        List<Device> devices=deviceRepository.findDevicesByFarmerId(getDevicesByFarmerIdQuery.farmerId());
        return devices;

    }
}
