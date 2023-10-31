package com.deviot.agripurebackend.profile.domain.model.commands;

import com.deviot.agripurebackend.profile.domain.model.enums.ProfileRole;

public record CreateProfileCommand(Long userId, Long suscritionId, String firstName, String lastName, String cellphone, ProfileRole role) {

}
