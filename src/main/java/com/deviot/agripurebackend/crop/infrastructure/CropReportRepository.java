package com.deviot.agripurebackend.crop.infrastructure;

import com.deviot.agripurebackend.crop.domain.model.aggregates.CropReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropReportRepository extends JpaRepository<CropReport,Long> {
}
