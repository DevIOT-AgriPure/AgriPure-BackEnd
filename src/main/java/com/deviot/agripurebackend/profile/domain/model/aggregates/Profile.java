package com.deviot.agripurebackend.profile.domain.model.aggregates;

import com.deviot.agripurebackend.profile.domain.model.enums.ProfileRole;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;

@Getter
@Setter
@Data
@Builder
@Entity
@Table(name = "profiles")
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId",nullable = false)
    private Long userId;

    @Column(name = "suscriptionId",nullable = false)
    private Long suscritionId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "cellphone",nullable = false)
    private String cellphone;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private ProfileRole importance;

}
