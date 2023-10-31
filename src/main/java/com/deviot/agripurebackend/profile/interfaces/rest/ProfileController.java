package com.deviot.agripurebackend.profile.interfaces.rest;


import com.deviot.agripurebackend.profile.application.internal.ProfileCommandService;
import com.deviot.agripurebackend.profile.application.internal.QueryService.ProfileQueryService;
import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileBySpecialistId;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByUserId;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/profiles")
public class ProfileController {

    private final ProfileCommandService profileCommandService;

    private final ProfileQueryService profileQueryService;

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileCommand createProfileCommand){
        this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok("Profile created!!");
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProfile(@RequestBody DeleteProfileCommand deleteProfileCommand){
        this.profileCommandService.handle(deleteProfileCommand);
        return ResponseEntity.ok("Profile deleted");
    }

    @GetMapping("/specialist/{specialistId}")
    public ResponseEntity<?> getProfileBySpecialistId(@PathVariable("specialistId") Long specialistId){
        GetProfileBySpecialistId getProfileBySpecialistId = new GetProfileBySpecialistId(specialistId);
        List<Profile> profiles = this.profileQueryService.handle(getProfileBySpecialistId);
        return ResponseEntity.ok(profiles);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getProfileByUserId(@PathVariable("userId") Long userId){
        GetProfileByUserId getProfileByUserId = new GetProfileByUserId(userId);
        List<Profile> profiles = this.profileQueryService.handle(getProfileByUserId);
        return ResponseEntity.ok(profiles);

    }

}
