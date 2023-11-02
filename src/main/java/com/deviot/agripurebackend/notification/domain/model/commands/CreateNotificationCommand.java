package com.deviot.agripurebackend.notification.domain.model.commands;

import com.deviot.agripurebackend.notification.domain.model.enums.NotificationImportance;

public record CreateNotificationCommand(String message,
                                        String imageUrl,
                                        String notificationType,
                                        String date,
                                        Long toAccountId,
                                        Long plantId,
                                        Long fromAccountId,
                                        Boolean seen) {

}
