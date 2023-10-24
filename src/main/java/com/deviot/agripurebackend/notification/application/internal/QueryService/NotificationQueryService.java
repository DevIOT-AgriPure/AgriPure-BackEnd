package com.deviot.agripurebackend.notification.application.internal.QueryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsById;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByUserId;
import com.deviot.agripurebackend.notification.domain.services.queryService.INotificationQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationQueryService implements INotificationQueryService {
    @Override
    public Notification handle(GetNotificationsById getNotificationsById) {
        return null;
    }

    @Override
    public List<Notification> handle(GetNotificationsByUserId getNotificationsByUserId) {
        return null;
    }
}
