package com.deviot.agripurebackend.notification.application.internal;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.notification.domain.services.INotificationsCommandService;
import com.deviot.agripurebackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationCommandService implements INotificationsCommandService {
    private final NotificationRepository notificationRepository;
    @Override
    public String handle(CreateNotificationCommand createNotificationCommand) {
        Notification newNotification = Notification.builder()
                .message(createNotificationCommand.message())
                .imageUrl(createNotificationCommand.imageUrl())
                .notificationType(createNotificationCommand.notificationType())
                .date(createNotificationCommand.date())
                .toAccountId(createNotificationCommand.toAccountId())
                .plantId(createNotificationCommand.plantId())
                .fromAccountId(createNotificationCommand.fromAccountId())
                .seen(createNotificationCommand.seen())
                .build();
        if (notificationRepository.save(newNotification)!=null){
            return "Notification registered";
        }
        return "Can't registered your notification";

    }

    @Override
    public String handle(DeleteNotificationCommand deleteNotificationCommand) {

        Optional<Notification> notification = notificationRepository.findById(deleteNotificationCommand.id());
        if (!notification.isEmpty()){
            return "Notification with id"+deleteNotificationCommand.id()+"was deleted";
        }
        return "Notification with id:"+ deleteNotificationCommand.id()+"doesnt exists";
    }

}
