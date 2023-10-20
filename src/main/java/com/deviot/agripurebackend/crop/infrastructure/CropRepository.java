package com.deviot.agripurebackend.crop.infrastructure;

import com.deviot.agripurebackend.crop.domain.model.aggregates.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropRepository extends JpaRepository<Crop,Long> {
}
