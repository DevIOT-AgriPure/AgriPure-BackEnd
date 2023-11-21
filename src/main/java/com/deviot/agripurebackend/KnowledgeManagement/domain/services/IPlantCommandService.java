package com.deviot.agripurebackend.KnowledgeManagement.domain.services;

import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.CreatePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.DeletePlantCommand;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.commands.GenerateSeedCommand;

public interface IPlantCommandService {
    String handle(GenerateSeedCommand generateSeedCommand);
    Long handle(CreatePlantCommand createPlantCommand);
    Long handle(DeletePlantCommand deletePlantCommand);

}
