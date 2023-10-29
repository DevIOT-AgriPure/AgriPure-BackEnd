package com.deviot.agripurebackend.advisory.domain.model.commands.project;

public record CreateProjectCommand(Long farmerId, Long specialistId, boolean isStarted, Long cropId, String name,String description,
                                   String startDate,String endDate) {
}
