package com.brendasoares.voting_session_management.model.dto;


import lombok.Builder;
import lombok.Value;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotNull;

@Value
@With
@Jacksonized
@Builder
public class AssociateDTO {

    @NotNull
    private String userName;

    public String getUserName() {
        return userName;
    }

}
