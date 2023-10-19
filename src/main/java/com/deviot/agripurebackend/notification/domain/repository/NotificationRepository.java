package com.deviot.agripurebackend.notification.domain.repository;


import com.deviot.agripurebackend.notification.domain.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> notifications();

    void add(Notification notification);
    void deleteProject(int projectId);

}