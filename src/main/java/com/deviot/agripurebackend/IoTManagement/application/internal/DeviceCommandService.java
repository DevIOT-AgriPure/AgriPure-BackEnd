package com.deviot.agripurebackend.IoTManagement.application.internal;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.*;
import com.deviot.agripurebackend.IoTManagement.domain.service.CommandService.IDeviceCommandService;
import com.deviot.agripurebackend.IoTManagement.infrastructure.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceCommandService implements IDeviceCommandService {
    private final DeviceRepository deviceRepository;


    @Override
    public String handle(createDeviceCommand command) {
        Device newDevice= Device.builder().name(command.name())
                .model(command.model())
                .category(command.category())
                .cropName(command.cropName())
                .farmerId(command.farmerId())
                .projectId(command.projectId())
                .active(false)
                .activeNotification(false)
                .activeRealTimeData(false)
                .build();
        deviceRepository.save(newDevice);
        return "Device created!!";
    }

    @Override
    public String handle(setActiveNotification command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActiveNotification(command.newStatus());
            return "Device status notification changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public String handle(setDeviceStatus command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActive(command.newStatus());
            return "Device status changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public String handle(SetRealTimeDataCommand command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setActiveRealTimeData(command.newStatus());
            return "Device status changed!!";
        }
        else{
            return "Device not found!";
        }
    }

    @Override
    public Long handle(SetTemperatureCommand command) {
        Optional<Device> device=deviceRepository.findById(command.deviceId());
        if(device.isPresent()){
            device.get().setPlanTemperature(command.temperature());
            deviceRepository.save(device.get());
            return 1L;
        }
        else{
            return 0L;
        }

    }
}