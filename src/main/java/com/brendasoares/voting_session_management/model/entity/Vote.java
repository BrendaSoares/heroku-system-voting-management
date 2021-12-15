package com.brendasoares.voting_session_management.model.entity;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Entity
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private Boolean choice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "associate")
    @NotNull
    private Associate associate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voting_session")
    @NotNull
    private VotingSession votingSession;

    public Vote() {
    }

    public Vote(Long id, Boolean choice, Associate associate, VotingSession votingSession) {
        this.id = id;
        this.choice = choice;
        this.associate = associate;
        this.votingSession = votingSession;
    }

    public Vote(VotingSession foundVotingSession, Associate foundAssociate, Boolean choice) {
        this.votingSession = foundVotingSession;
        this.associate = foundAssociate;
        this.choice = choice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getChoice() {
        return choice;
    }

    public void setChoice(Boolean choice) {
        this.choice = choice;
    }

    public Associate getAssociate() {
        return associate;
    }

    public void setAssociate(Associate associate) {
        this.associate = associate;
    }

    public VotingSession getVotingSession() {
        return votingSession;
    }

    public void setVotingSession(VotingSession votingSession) {
        this.votingSession = votingSession;
    }
}
