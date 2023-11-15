package com.deviot.agripurebackend.IoTManagement.interfaces;

import com.deviot.agripurebackend.IoTManagement.application.internal.DeviceCommandService;
import com.deviot.agripurebackend.IoTManagement.application.internal.DeviceQueryService;
import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.*;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDevicesByFarmerIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;
import com.deviot.agripurebackend.IoTManagement.interfaces.dto.DeviceValuesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;


    @GetMapping("/temperaturehumidity/{id}")
    public ResponseEntity<DeviceValuesDTO> GetTemperature(@PathVariable("id") Long id){
        getTemperatureQuery query=new getTemperatureQuery(id);
        Device device = deviceQueryService.handle(query);
        DeviceValuesDTO deviceValuesDTO=DeviceValuesDTO.builder()
                .planTemperature(device.getPlanTemperature())
                .planHumidity(device.getPlanHumidity())
                .build();
        return ResponseEntity.ok(deviceValuesDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Device> GetDevice(@PathVariable("id")Long id){
        GetDeviceByIdQuery query=new GetDeviceByIdQuery(id);
        Device response=deviceQueryService.handle(query);
        return ResponseEntity.ok(response);

    }
    @GetMapping("getDevicesByFarmerId/{farmerId}")
    public List<Device> GetDevicesByFarmerId(@PathVariable("farmerId")Long farmerId){
        GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery=new GetDevicesByFarmerIdQuery(farmerId);
        List<Device> devices=deviceQueryService.handle(getDevicesByFarmerIdQuery);
        return devices;

    }
    @PostMapping()
    public ResponseEntity<?> CreateDevice(@RequestBody createDeviceCommand command){
        Long response= deviceCommandService.handle(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("notification")
    public ResponseEntity<?> SetActiveNotification(@RequestBody setActiveNotification command){
        String response=deviceCommandService.handle(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("status")
    public ResponseEntity<?> SetDeviceStatus(@RequestBody setDeviceStatus command){
        String response=deviceCommandService.handle(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("realtimedata")
    public ResponseEntity<?> SetRealTimeData(@RequestBody SetRealTimeDataCommand command){
        String response=deviceCommandService.handle(command);
        return ResponseEntity.ok(response);
    }

    @PostMapping("temperature")
    public ResponseEntity<?> SetTemperature(@RequestBody SetTemperatureCommand command){
        Long response=deviceCommandService.handle(command);
        return ResponseEntity.ok(response);
    }

}
