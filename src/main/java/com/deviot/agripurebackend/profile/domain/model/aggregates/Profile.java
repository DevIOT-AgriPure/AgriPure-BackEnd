package com.deviot.agripurebackend.profile.domain.model.aggregates;
import com.deviot.agripurebackend.profile.domain.model.enums.ProfileRol;
import jakarta.persistence.*;
import lombok.*;


import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profiles", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId",nullable = false)
    private int userId;

    @Column(name = "suscriptionId",nullable = false)
    private int suscritionId;

    @Column(name = "firstName",nullable = false)
    private String firstName;

    @Column(name = "lastName",nullable = false)
    private String lastName;

    @Column(name = "cellphone",nullable = false)
    private String cellphone;



}
