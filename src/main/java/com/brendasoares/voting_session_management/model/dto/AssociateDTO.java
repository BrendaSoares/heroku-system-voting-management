package com.brendasoares.voting_session_management.model.dto;


import javax.validation.constraints.NotNull;

public class AssociateDTO {

    @NotNull
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
