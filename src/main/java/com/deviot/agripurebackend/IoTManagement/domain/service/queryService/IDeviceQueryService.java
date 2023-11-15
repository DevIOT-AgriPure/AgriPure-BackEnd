package com.deviot.agripurebackend.IoTManagement.domain.service.queryService;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDevicesByFarmerIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;

import java.util.List;

public interface IDeviceQueryService {

    Device handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);
    List<Device> handle(GetDevicesByFarmerIdQuery getDevicesByFarmerIdQuery);
}
