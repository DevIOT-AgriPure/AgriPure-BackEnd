package com.deviot.agripurebackend.crop.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "crop_reports")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CropReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "description")
    private String description;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name="image")
    private byte[] image;

    @Column(name="crop_id")
    private Long cropId;

}
