package com.deviot.agripurebackend.notification.application.internal;

import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.notification.domain.services.INotificationsCommandService;
import com.deviot.agripurebackend.notification.infrastructure.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationCommandService implements INotificationsCommandService {
    private final NotificationRepository notificationRepository;
    @Override
    public String handle(CreateNotificationCommand createNotificationCommand) {
        Notification newNotification = Notification.builder()
                .userId(createNotificationCommand.userId())
                .importance(createNotificationCommand.importance())
                .title(createNotificationCommand.title())
                .body(createNotificationCommand.body())
                .createAt(new Date())
                .build();
        if (notificationRepository.save(newNotification)!=null){
            return "Notification registered";
        }
        return "Can't registered your notification";

    }

    @Override
    public String handle(DeleteNotificationCommand deleteNotificationCommand) {
        Optional<Notification> notification = notificationRepository.findById(deleteNotificationCommand.userId());
        if (notification.isPresent()){
            notificationRepository.deleteById(deleteNotificationCommand.userId());
            return "Notification with id"+deleteNotificationCommand.userId()+"was deleted";
        }
        return "Notification with id:"+ deleteNotificationCommand.userId()+"doesnt exists";
    }
}
