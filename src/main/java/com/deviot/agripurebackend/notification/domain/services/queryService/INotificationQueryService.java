package com.deviot.agripurebackend.notification.domain.services.queryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsById;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByUserId;

import java.util.List;

public interface INotificationQueryService {
    Notification handle(GetNotificationsById getNotificationsById);
    List<Notification> handle(GetNotificationsByUserId getNotificationsByUserId);
}
