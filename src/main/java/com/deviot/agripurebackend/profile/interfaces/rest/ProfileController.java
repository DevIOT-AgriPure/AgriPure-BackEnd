package com.deviot.agripurebackend.profile.interfaces.rest;
import com.deviot.agripurebackend.profile.application.internal.ProfileCommandService;
import com.deviot.agripurebackend.profile.application.internal.QueryService.ProfileQueryService;
import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.UpdateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByAccountIdQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileCommand createProfileCommand){
        this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok("Profile created!!!");
    }
    @GetMapping("/getProfile/{accountId}")
    public ResponseEntity<?> getProfileByAccountId(@PathVariable("accountId")Long accountId){
        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);
        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        if (profile!=null){
            return ResponseEntity.ok(profile);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProfileByAccountId(@RequestBody UpdateProfileCommand updateProfileCommand){
        String message=this.profileCommandService.handle(updateProfileCommand);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/deleteProfile/{accountId}")
    public ResponseEntity<?> deleteProfileByAccountId(@PathVariable("accountId")Long accountId){
        DeleteProfileCommand deleteProfileCommand=new DeleteProfileCommand(accountId);
        String message=this.profileCommandService.handle(deleteProfileCommand);
        return ResponseEntity.ok(message);
    }
}
