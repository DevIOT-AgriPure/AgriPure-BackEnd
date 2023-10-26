package com.deviot.agripurebackend.IoTManagement.infrastructure;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregates.DeviceCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceCatalog, Long> {
}
