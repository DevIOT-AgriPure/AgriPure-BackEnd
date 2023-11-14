package com.deviot.agripurebackend.suscription.domain.model.commands;

public record UpdateSubscriptionCommand(Long accountId, Boolean active) {
}
