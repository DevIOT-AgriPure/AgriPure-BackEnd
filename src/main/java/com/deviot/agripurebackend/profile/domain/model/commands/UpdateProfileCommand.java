package com.deviot.agripurebackend.profile.domain.model.commands;

public record UpdateProfileCommand(String name,String description,String imageUrl,String location) {
}
