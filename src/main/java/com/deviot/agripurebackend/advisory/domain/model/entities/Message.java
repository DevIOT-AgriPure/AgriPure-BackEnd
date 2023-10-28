package com.deviot.agripurebackend.advisory.domain.model.entities;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Entity
@Table(name = "messages")
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "contact_id")
    private long contactId;

    @Column(name = "author_id")
    private long authorId;

    @Column(name = "message")
    private String message;

    @Column(name = "hour")
    private String hour;

}
