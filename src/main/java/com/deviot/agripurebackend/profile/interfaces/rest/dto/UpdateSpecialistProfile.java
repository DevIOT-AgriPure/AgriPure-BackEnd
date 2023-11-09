package com.deviot.agripurebackend.profile.interfaces.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSpecialistProfile {
    Long accountId;
    String email;
    String name;
    String description;
    String imageUrl;
    String imageName;
    String location;
    String expertise;
    String contactEmail;
    String areasOfFocus;
}
