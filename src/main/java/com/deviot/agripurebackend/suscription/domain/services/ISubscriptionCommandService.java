package com.deviot.agripurebackend.suscription.domain.services;

import com.deviot.agripurebackend.suscription.domain.model.commands.CreateSubscriptionCommand;
import com.deviot.agripurebackend.suscription.domain.model.commands.DeleteSubscriptionCommand;
import com.deviot.agripurebackend.suscription.domain.model.commands.UpdateSubscriptionCommand;

public interface ISubscriptionCommandService {
    String handle(CreateSubscriptionCommand createSubscriptionCommand);
    String handle(UpdateSubscriptionCommand updateSubscriptionCommand);
    String handle(DeleteSubscriptionCommand deleteSubscriptionCommand);
}
