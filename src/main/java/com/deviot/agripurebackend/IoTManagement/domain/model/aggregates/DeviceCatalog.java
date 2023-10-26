package com.deviot.agripurebackend.IoTManagement.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "devices")
public class DeviceCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "category")
    private String category;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name = "stock")
    private Long stock;

    @Column(name="specifications")
    private String specifications;

}
