package com.deviot.agripurebackend.account.domain.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;


@Getter
@Setter
@Data
public class account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    public account(Long id, String e, String p){
        this.id=id;
        this.email=e;
        this.password=p;
    }

    public account (String e,String p){
        this.email=e;
        this.password=p;
    }
}
