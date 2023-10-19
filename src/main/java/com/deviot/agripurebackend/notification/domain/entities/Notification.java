package com.deviot.agripurebackend.notification.domain.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;

@Getter
@Setter
@Data

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private Date createAt;
    private String title;
    private String body;
    private String importance;

    public Notification(Long id, int u, Date c, String t, String b, String ii){
        this.id=id;
        this.userId=u;
        this.createAt=c;
        this.title=t;
        this.body=b;
        this.importance=ii;

    }
}

