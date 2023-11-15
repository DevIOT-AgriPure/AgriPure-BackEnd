package com.deviot.agripurebackend.IoTManagement.infrastructure;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregate.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeviceRepository extends JpaRepository<Device,Long> {
    List<Device> findDevicesByFarmerId(Long farmerId);
}
