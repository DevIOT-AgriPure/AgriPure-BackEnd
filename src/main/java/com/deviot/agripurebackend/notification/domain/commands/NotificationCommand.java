package com.deviot.agripurebackend.notification.domain.commands;

import lombok.Getter;
import java.util.Date;

@Getter
public class NotificationCommand {
    int userId;
    Date createAt;
    String title;
    String body;
    String importance;

    public NotificationCommand(Date createAt, String title, String body, String importance){
        this.createAt = createAt;
        this.title = title;
        this.body = body;
        this.importance = importance;
    }
}
