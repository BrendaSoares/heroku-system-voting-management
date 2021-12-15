package com.brendasoares.voting_session_management.util.creator;

import com.brendasoares.voting_session_management.model.dto.VoteDTO;
import com.brendasoares.voting_session_management.model.entity.Vote;

import static com.brendasoares.voting_session_management.util.creator.AssociateCreator.createAssociateValid;
import static com.brendasoares.voting_session_management.util.creator.VotingSessionCreator.createValidVotingSession;

public class VoteCreator {

    public static Vote createValidVote() {
        return Vote.builder()
                .id(1L)
                .choice(true)
                .associate(createAssociateValid())
                .votingSession(createValidVotingSession())
                .build();
    }

    public static VoteDTO createValidVoteDto() {
        return VoteDTO.builder()
                .choice(true)
                .idAssociate(createAssociateValid().getId())
                .idVotingsession(createValidVotingSession().getId())
                .build();
    }

}
