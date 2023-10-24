package com.deviot.agripurebackend.crop.interfaces.rest;

import com.deviot.agripurebackend.crop.application.internal.CropCommandService;
import com.deviot.agripurebackend.crop.application.internal.QueryService.CropQueryService;
import com.deviot.agripurebackend.crop.domain.model.commands.CreateCropCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/crops")
public class CropController {
    private final CropCommandService cropCommandService;
    private final CropQueryService cropQueryService;

    @PostMapping
    public ResponseEntity<?> createCrop(CreateCropCommand createCropCommand){
        this.cropCommandService.handle(createCropCommand);
        return ResponseEntity.ok("Crop created!!!");
    }


}
