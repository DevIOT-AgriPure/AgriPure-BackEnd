package com.deviot.agripurebackend.crop.infrastructure;

import com.deviot.agripurebackend.crop.domain.model.aggregates.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop,Long> {
}
