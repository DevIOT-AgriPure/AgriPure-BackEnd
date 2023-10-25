package com.deviot.agripurebackend.notification.interfaces.rest;


import com.deviot.agripurebackend.notification.application.internal.NotificationCommandService;
import com.deviot.agripurebackend.notification.application.internal.QueryService.NotificationQueryService;
import com.deviot.agripurebackend.notification.domain.model.aggregates.Notification;
import com.deviot.agripurebackend.notification.domain.model.commands.CreateNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.DeleteNotificationCommand;
import com.deviot.agripurebackend.notification.domain.model.commands.GetAllNotificationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class NotificationController {

    private final NotificationCommandService notificationCommandService;

    private final NotificationQueryService notificationQueryService;

    @PostMapping("notifications")
    public ResponseEntity<?> createNotification(@RequestBody CreateNotificationCommand createNotificationCommand){
        this.notificationCommandService.handle(createNotificationCommand);
        return ResponseEntity.ok("Notification created!!");
    }

    @GetMapping("notifications")
    public Iterable<Notification> getNotifications(){
        return notificationCommandService.handle();
    }

    //@DeleteMapping("notifications/{userId}")
    //public ResponseEntity<?> deleteNotification(@PathVariable("userId") Long userId){
    //    this.notificationCommandService.deleteNotificationsByUserId(userId);
     //   return ResponseEntity.ok("Notification deleted");
    //}

    @DeleteMapping("notifications/{userId}")
    public ResponseEntity<?> deleteNotification(@RequestBody DeleteNotificationCommand deleteNotificationCommand){
        this.notificationCommandService.handle(deleteNotificationCommand);
        return ResponseEntity.ok("Notification deleted");
    }

}
