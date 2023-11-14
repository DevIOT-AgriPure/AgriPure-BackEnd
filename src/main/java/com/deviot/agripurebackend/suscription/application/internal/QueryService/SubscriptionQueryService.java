package com.deviot.agripurebackend.suscription.application.internal.QueryService;

import com.deviot.agripurebackend.suscription.domain.model.aggregates.Subscription;
import com.deviot.agripurebackend.suscription.domain.model.queries.GetSubscriptionByAccountIdQuery;
import com.deviot.agripurebackend.suscription.domain.services.queryService.ISubscriptionQueryService;
import com.deviot.agripurebackend.suscription.infrastructure.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionQueryService implements ISubscriptionQueryService {
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Subscription handle(GetSubscriptionByAccountIdQuery getSubscriptionByAccountIdQuery) {
        Optional<Subscription> subscription=Optional.ofNullable(subscriptionRepository.findSubscriptionByAccountId(getSubscriptionByAccountIdQuery.accountId()));
        if(subscription.isPresent()){
            return subscription.get();
        }else {
            return null;
        }
    }
}
