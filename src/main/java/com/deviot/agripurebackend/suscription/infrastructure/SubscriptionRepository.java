package com.deviot.agripurebackend.suscription.infrastructure;

import com.deviot.agripurebackend.profile.domain.model.aggregates.Profile;
import com.deviot.agripurebackend.suscription.domain.model.aggregates.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription,Long> {
    Subscription findSubscriptionByAccountId(Long accountId);
}
