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
    private int suscriptionId;
    private String firstName;
    private String lastName;
    private String cellphone;

    public profile(Long id, int u, int s, String f, String l, String c){
        this.id=id;
        this.userId=u;
        this.suscriptionId=s;
        this.firstName=f;
        this.lastName=l;
        this.cellphone=c;
    }

    public profile (int u, int s, String f, String l, String c){
        this.userId=u;
        this.suscriptionId=s;
        this.firstName=f;
        this.lastName=l;
        this.cellphone=c;
    }
}