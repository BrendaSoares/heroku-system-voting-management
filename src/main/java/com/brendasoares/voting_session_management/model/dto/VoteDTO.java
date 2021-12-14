package com.brendasoares.voting_session_management.model.dto;

import javax.validation.constraints.NotNull;

public class VoteDTO {

    @NotNull
    private Boolean choice;

    @NotNull
    private Long idAssociate;

    @NotNull
    private Long idVotingsession;

    public VoteDTO() {
    }

    public VoteDTO(Boolean choice, Long idAssociate, Long idVotingsession) {
        this.choice = choice;
        this.idAssociate = idAssociate;
        this.idVotingsession = idVotingsession;
    }

    public Boolean getChoice() {
        return choice;
    }

    public void setChoice(Boolean choice) {
        this.choice = choice;
    }

    public Long getIdAssociate() {
        return idAssociate;
    }

    public void setIdAssociate(Long idAssociate) {
        this.idAssociate = idAssociate;
    }

    public Long getIdVotingsession() {
        return idVotingsession;
    }

    public void setIdVotingsession(Long idVotingsession) {
        this.idVotingsession = idVotingsession;
    }
}
