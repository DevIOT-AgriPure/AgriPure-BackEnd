package com.deviot.agripurebackend.notification.domain.model.aggregates;

import com.deviot.agripurebackend.notification.domain.model.enums.NotificationImportance;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Enumerated(EnumType.STRING)
    @Column(name = "importance")
    private NotificationImportance importance;

}

