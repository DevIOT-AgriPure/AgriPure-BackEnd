package com.deviot.agripurebackend.IoTManagement.domain.services.query;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregates.Device;
import com.deviot.agripurebackend.IoTManagement.domain.model.aggregates.DeviceCatalog;
import com.deviot.agripurebackend.IoTManagement.domain.model.queries.deviceCatalog.findDeviceCatalogId;

public interface IDeviceCatalogQueryService {
    DeviceCatalog handle(findDeviceCatalogId findDeviceCatalogId);

}
