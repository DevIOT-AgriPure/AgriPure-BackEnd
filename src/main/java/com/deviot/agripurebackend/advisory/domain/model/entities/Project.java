package com.deviot.agripurebackend.advisory.domain.model.entities;

import jakarta.persistence.*;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Entity
@RequiredArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ind;

    @Column(name="farmer_id")
    private Long farmerId;

    @Column(name = "specialist_id")
    private Long specialistId;

    @Column(name="is_project_started")
    private boolean isProjectStarted;

    @Column(name="crop_id")
    private Long cropId;

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;


}
