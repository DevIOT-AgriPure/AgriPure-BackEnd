package com.deviot.agripurebackend.IoTManagement.domain.service.queryService;

import com.deviot.agripurebackend.IoTManagement.domain.model.queries.getTemperatureQuery;

public interface IDeviceQueryService {

    double handle(getTemperatureQuery query);
}
