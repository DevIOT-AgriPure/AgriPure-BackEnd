package com.deviot.agripurebackend.IoTManagement.interfaces;

import com.deviot.agripurebackend.IoTManagement.application.internal.DeviceCommandService;
import com.deviot.agripurebackend.IoTManagement.application.internal.DeviceQueryService;
import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.commands.*;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/devices")
public class DeviceController {
    private final DeviceCommandService deviceCommandService;
    private final DeviceQueryService deviceQueryService;


    @GetMapping("/temperature/{id}")
    public ResponseEntity<Double> GetTemperature(@PathVariable("id") Long id){
        getTemperatureQuery query=new getTemperatureQuery(id);
        Double response = deviceQueryService.handle(query);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Device> GetDevice(@PathVariable("id")Long id){
        GetDeviceByIdQuery query=new GetDeviceByIdQuery(id);
        Device response=deviceQueryService.handle(query);
        return ResponseEntity.ok(response);

    }
    @PostMapping()
    public ResponseEntity<?> CreateDevice(@RequestBody createDeviceCommand command){
        String response= deviceCommandService.handle(command);
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
