package com.brendasoares.voting_session_management.model.converter;

import com.brendasoares.voting_session_management.model.dto.VoteDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.model.entity.Vote;
import com.brendasoares.voting_session_management.model.entity.VotingSession;

public class VoteConverter {

    public static Vote toEntity(VotingSession foundVotingSession, Associate foundAssociate, VoteDTO voteDTO){
        return new Vote(foundVotingSession, foundAssociate, voteDTO.getChoice());
    }

    public static VoteDTO toDTO(Vote vote){
        return new VoteDTO(vote.getChoice(), vote.getAssociate().getId(), vote.getVotingSession().getId());
    }
}


