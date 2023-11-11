package com.deviot.agripurebackend.suscription.domain.model.commands;

public record CreateSubscriptionCommand(Long accountId, String validDate,Boolean active) {
}
