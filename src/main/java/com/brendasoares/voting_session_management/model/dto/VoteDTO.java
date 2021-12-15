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
public class VoteDTO {

    @NotNull
    private Boolean choice;

    @NotNull
    private Long idAssociate;

    @NotNull
    private Long idVotingsession;


    public VoteDTO(Boolean choice, Long idAssociate, Long idVotingsession) {
        this.choice = choice;
        this.idAssociate = idAssociate;
        this.idVotingsession = idVotingsession;
    }

    public Boolean getChoice() {
        return choice;
    }

    public Long getIdAssociate() {
        return idAssociate;
    }

    public Long getIdVotingsession() {
        return idVotingsession;
    }
}
