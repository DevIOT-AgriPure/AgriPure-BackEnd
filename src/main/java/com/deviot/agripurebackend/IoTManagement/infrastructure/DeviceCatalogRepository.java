package com.deviot.agripurebackend.IoTManagement.infrastructure;

import com.deviot.agripurebackend.IoTManagement.domain.model.aggregates.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeviceCatalogRepository extends JpaRepository<Device,Long> {

    List<Device> findDeviceByFarmerId(Long farmerId);
}
