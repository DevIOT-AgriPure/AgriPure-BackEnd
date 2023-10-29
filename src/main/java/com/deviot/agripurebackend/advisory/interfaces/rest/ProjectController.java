package com.deviot.agripurebackend.advisory.interfaces.rest;

import com.deviot.agripurebackend.advisory.application.internal.project.ProjectCommandService;
import com.deviot.agripurebackend.advisory.application.internal.project.ProjectQueryService;
import com.deviot.agripurebackend.advisory.domain.model.commands.proyect.CreateProjectCommand;
import com.deviot.agripurebackend.advisory.domain.model.entities.Project;
import com.deviot.agripurebackend.advisory.domain.model.queries.proyect.GetProjectByIdQuery;
import com.deviot.agripurebackend.advisory.domain.model.queries.proyect.GetProjectsByFarmerIdQuery;
import com.deviot.agripurebackend.advisory.domain.model.queries.proyect.GetProjectsBySpecialistIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    @PostMapping
    public ResponseEntity<?> createProject(@RequestBody CreateProjectCommand createProjectCommand){
        this.projectCommandService.handle(createProjectCommand);
        return ResponseEntity.ok("Project Created!!");
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable("projectId") Long projectId){
        GetProjectByIdQuery getProjectByIdQuery=new GetProjectByIdQuery(projectId);
        Project project=this.projectQueryService.handle(getProjectByIdQuery);
        if(project!=null){
            return ResponseEntity.ok(project);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{farmerId}")
    public ResponseEntity<?> getProjectsByFarmerId(@PathVariable("farmerId") Long farmerId){
        GetProjectsByFarmerIdQuery getProjectsByFarmerIdQuery=new GetProjectsByFarmerIdQuery(farmerId);
        List<Project> projects=this.projectQueryService.handle(getProjectsByFarmerIdQuery);
        if(projects!=null){
            return ResponseEntity.ok(projects);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{specialistId}")
    public ResponseEntity<?> getProjectsBySpecialistId(@PathVariable("specialistId") Long specialistId){
        GetProjectsBySpecialistIdQuery getProjectsBySpecialistIdQuery=new GetProjectsBySpecialistIdQuery(specialistId);
        List<Project> projects=this.projectQueryService.handle(getProjectsBySpecialistIdQuery);
        if(projects!=null){
            return ResponseEntity.ok(projects);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
