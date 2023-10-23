package com.deviot.agripurebackend.crop.application.internal;

import com.deviot.agripurebackend.crop.domain.model.aggregates.CropReport;
import com.deviot.agripurebackend.crop.domain.model.commands.AddCropReportCommand;
import com.deviot.agripurebackend.crop.domain.model.commands.DeleteCropReportCommand;
import com.deviot.agripurebackend.crop.domain.services.ICropRepositoryCommandService;
import com.deviot.agripurebackend.crop.infrastructure.CropReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CropReportCommandService implements ICropRepositoryCommandService {

    CropReportRepository cropReportRepository;
    @Override
    public String handle(AddCropReportCommand addCropReportCommand) throws IOException {
        CropReport report=CropReport.builder()
                .createdAt(new Date())
                .description(addCropReportCommand.description())
                .image(addCropReportCommand.image().getBytes())
                .cropId(addCropReportCommand.cropId())
                .build();
        cropReportRepository.save(report);
        return "Report registered!!!";

    }


    @Override
    public String handle(DeleteCropReportCommand deleteCropReportCommand) {
        Optional<CropReport> report=cropReportRepository.findById(deleteCropReportCommand.reportId());
        if(report.isPresent()){
            cropReportRepository.deleteById(deleteCropReportCommand.reportId());
            return "Report with ID: "+deleteCropReportCommand.reportId()+" was deleted";
        }
        return "Report with ID:"+deleteCropReportCommand.reportId()+" doesn't exist";
    }
}
