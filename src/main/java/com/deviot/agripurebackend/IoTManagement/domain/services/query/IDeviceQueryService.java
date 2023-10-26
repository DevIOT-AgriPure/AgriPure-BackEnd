package com.deviot.agripurebackend.IoTManagement.domain.services.query;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregates.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.device.findDeviceByFarmerId;

import java.util.List;

public interface IDeviceQueryService {
    List<Device> handle(findDeviceByFarmerId findDeviceByFarmerId);
}
