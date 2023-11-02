package com.deviot.agripurebackend.notification.application.internal.QueryService;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.queries.GetNotificationsByToAccountId;
import com.deviot.agripurebackend.notification.domain.services.queryService.INotificationQueryService;
import com.deviot.agripurebackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationQueryService implements INotificationQueryService {

    private final NotificationRepository notificationRepository;

    @Override
    public List<Notification> handle(GetNotificationsByToAccountId getNotificationsByToAccountId) {
        List<Notification> notifications = notificationRepository.findNotificationByToAccountId(getNotificationsByToAccountId.toAccountId());
        return notifications;
    }
}
