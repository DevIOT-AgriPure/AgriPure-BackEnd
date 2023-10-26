package com.deviot.agripurebackend.IoTManagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "farmer_id")
    private Long farmerId;

    @Column(name = "device_catalog_id")
    private Long deviceCatalogId;

    @Column(name="crop_id")
    private Long cropId;
}
