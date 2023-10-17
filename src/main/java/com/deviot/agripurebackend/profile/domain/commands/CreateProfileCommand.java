package com.deviot.agripurebackend.profile.domain.commands;

import lombok.Getter;

@Getter
public class CreateProfileCommand {
    private int userId;
    private int suscripcionId;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String rol;

    public CreateProfileCommand(int userId, int suscripcionId, String firstName, String lastName, String cellphone, String rol){
        this.userId=userId;
        this.suscripcionId=suscripcionId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cellphone=cellphone;
        this.rol=rol;
    }
}