package com.deviot.agripurebackend.IoTManagement.domain.service.queryService;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.GetDeviceByIdQuery;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;

public interface IDeviceQueryService {

    double handle(getTemperatureQuery query);
    Device handle(GetDeviceByIdQuery query);
}
