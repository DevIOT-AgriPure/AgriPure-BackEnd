package com.deviot.agripurebackend.profile.interfaces.rest;
import com.deviot.agripurebackend.account.application.internal.QueryService.AccountQueryService;
import com.deviot.agripurebackend.account.domain.model.aggregates.Account;
import com.deviot.agripurebackend.account.domain.model.enums.AccountRol;
import com.deviot.agripurebackend.account.domain.model.queries.GetEmailAndTypeByAccountIdQuery;
import com.deviot.agripurebackend.account.domain.model.queries.GetFarmersQuery;
import com.deviot.agripurebackend.profile.application.internal.ProfileCommandService;
import com.deviot.agripurebackend.profile.application.internal.QueryService.ProfileQueryService;
import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.profile.domain.model.commands.CreateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.DeleteProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.commands.UpdateProfileCommand;
import com.deviot.agripurebackend.profile.domain.model.queries.GetProfileByAccountIdQuery;
import com.deviot.agripurebackend.profile.interfaces.rest.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/profiles")
public class ProfileController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;
    private final AccountQueryService accountQueryService;

    @PostMapping
    public ResponseEntity<?> createProfile(@RequestBody CreateProfileCommand createProfileCommand){
        this.profileCommandService.handle(createProfileCommand);
        return ResponseEntity.ok("Profile created!!!");
    }
    @GetMapping("/getProfile/{accountId}")
    public ResponseEntity<?> getUserByAccountId(@PathVariable("accountId")Long accountId){
        GetProfileByAccountIdQuery getProfileByAccountIdQuery=new GetProfileByAccountIdQuery(accountId);
        GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery =new GetEmailAndTypeByAccountIdQuery(accountId);

        Profile profile=this.profileQueryService.handle(getProfileByAccountIdQuery);
        Account account=this.accountQueryService.handle(getEmailAndTypeByAccountIdQuery);

        if (profile!=null && account!=null){
            User user=User.builder()
                    .email(account.getEmail())
                    .name(profile.getName())
                    .description(profile.getDescription())
                    .imageUrl(profile.getImageUrl())
                    .location(profile.getLocation())
                    .type(account.getRol().toString())
                    .planId(profile.getPlanId())
                    .accountId(profile.getAccountId())
                    .build();

            return ResponseEntity.ok(user);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getFarmers")
    public ResponseEntity<?>getAllProfilesByFarmerType(){
        GetFarmersQuery getFarmersQuery=new GetFarmersQuery(AccountRol.FARMER);
        List<Account> accounts=this.accountQueryService.handle(getFarmersQuery);
        if (accounts != null) {
            List<User> users = new ArrayList<>();

            for (Account account : accounts) {
                GetProfileByAccountIdQuery getProfileByAccountIdQuery = new GetProfileByAccountIdQuery(account.getId());
                GetEmailAndTypeByAccountIdQuery getEmailAndTypeByAccountIdQuery = new GetEmailAndTypeByAccountIdQuery(account.getId());

                Profile profile = this.profileQueryService.handle(getProfileByAccountIdQuery);

                if (profile != null) {
                    User user = User.builder()
                            .email(account.getEmail())
                            .name(profile.getName())
                            .description(profile.getDescription())
                            .imageUrl(profile.getImageUrl())
                            .location(profile.getLocation())
                            .type(account.getRol().toString())
                            .planId(profile.getPlanId())
                            .accountId(profile.getAccountId())
                            .build();
                    users.add(user);
                }
            }

            return ResponseEntity.ok(users);
        } else {
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
