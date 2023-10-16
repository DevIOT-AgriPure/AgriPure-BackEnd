package com.deviot.agripurebackend.account.domain.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Data
public class account {
    private Long id;
    private String email;
    private String password;

    public account(Long id, String e, String p){
        this.id=id;
        this.email=e;
        this.password=p;
    }
}
