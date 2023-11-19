package com.deviot.agripurebackend.KnowledgeManagement.domain.services;

import com.deviot.agripurebackend.KnowledgeManagement.domain.model.aggregates.Plant;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.queries.GetPlantByIdQuery;
import com.deviot.agripurebackend.KnowledgeManagement.domain.model.queries.GetTemperatureAndHumidityRangesByPlantIdQuery;
import com.deviot.agripurebackend.KnowledgeManagement.interfaces.resources.RangesDTO;

import java.util.List;

public interface IPlantQueryService {
    Plant handle(GetPlantByIdQuery getPlantByIdQuery);
    RangesDTO handle(GetTemperatureAndHumidityRangesByPlantIdQuery query);
    List<Plant>handle();
}
