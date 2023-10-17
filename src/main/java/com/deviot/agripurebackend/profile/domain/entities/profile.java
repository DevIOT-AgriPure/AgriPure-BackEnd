package com.deviot.agripurebackend.profile.domain.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter
@Data
public class profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;
    private int suscripcionId;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String rol;

    public profile(Long id, int u, int s, String f, String l, String c, String r){
        this.id=id;
        this.userId=u;
        this.suscripcionId=s;
        this.firstName=f;
        this.lastName=l;
        this.cellphone=c;
        this.rol=r;
    }

    public profile (int u, int s, String f, String l, String c, String r){
        this.userId=u;
        this.suscripcionId=s;
        this.firstName=f;
        this.lastName=l;
        this.cellphone=c;
        this.rol=r;
    }
}