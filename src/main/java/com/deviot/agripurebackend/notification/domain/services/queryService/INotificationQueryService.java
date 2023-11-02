package com.deviot.agripurebackend.notification.domain.services.queryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByToAccountId;

import java.util.List;

public interface INotificationQueryService {
    List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId);
}
