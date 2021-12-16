package com.brendasoares.voting_session_management.model.dto;

import lombok.Builder;

import javax.validation.constraints.NotNull;

@Builder
public class VotingSessionDTO {

    @NotNull
    private Long idTopic;

    public VotingSessionDTO(Long idTopic) {
        this.idTopic = idTopic;
    }

    public Long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Long idTopic) {
        this.idTopic = idTopic;
    }
}