package com.deviot.agripurebackend.IoTManagement.domain.model.aggregate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "category")
    private String category;

    @Column(name="crop_name")
    private String cropName;

    @Column(name = "farmer_id")
    private long farmerId;

    @Column(name="project_id")
    private Long projectId;

    @Column(name="active")
    private boolean active;

    @Column(name="active_notification")
    private boolean activeNotification;

    @Column(name = "active_real_time_data")
    private boolean activeRealTimeData;

    @Column(name="plan_temperature")
    private double planTemperature;
}
