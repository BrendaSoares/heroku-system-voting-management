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
public class VotingSessionDTO {

    @NotNull
    private Long idTopic;

    public Long getIdTopic() {
        return idTopic;
    }

}