package com.deviot.agripurebackend.profile.domain.model.commands;

import lombok.Getter;

@Getter
public class CreateProfileCommand {
    private int userId;
    private int suscriptionId;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String rol;

    public CreateProfileCommand(int userId, int suscriptionId, String firstName, String lastName, String cellphone, String rol){
        this.userId=userId;
        this.suscriptionId=suscriptionId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.cellphone=cellphone;
        this.rol=rol;
    }
}