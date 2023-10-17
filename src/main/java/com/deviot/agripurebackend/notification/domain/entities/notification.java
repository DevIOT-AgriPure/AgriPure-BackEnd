package com.deviot.agripurebackend.notification.domain.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
@Getter
@Setter
@Data

public class notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private String createAt;
    private String title;
    private String body;
    private String importance;

    public notification(Long id, int u, String c, String t, String b, String i){
        this.id=id;
        this.userId=u;
        this.createAt=c;
        this.title=t;
        this.body=b;
        this.importance=i;

    }
}

