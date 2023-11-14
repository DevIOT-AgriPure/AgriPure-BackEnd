package com.deviot.agripurebackend.suscription.domain.services.queryService;

import com.deviot.agripurebackend.suscription.domain.model.aggregates.Subscription;
import com.deviot.agripurebackend.suscription.domain.model.queries.GetSubscriptionByAccountIdQuery;

public interface ISubscriptionQueryService {
    Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery);
}
