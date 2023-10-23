package com.deviot.agripurebackend.crop.domain.model.commands;

import org.springframework.web.multipart.MultipartFile;

public record AddCropReportCommand(Long cropId, String description, MultipartFile image) {
}
