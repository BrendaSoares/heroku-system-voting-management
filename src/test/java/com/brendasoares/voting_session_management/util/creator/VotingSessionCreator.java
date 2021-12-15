package com.brendasoares.voting_session_management.util.creator;

import com.brendasoares.voting_session_management.model.dto.VotingSessionDTO;
import com.brendasoares.voting_session_management.model.entity.Vote;
import com.brendasoares.voting_session_management.model.entity.VotingSession;

import static com.brendasoares.voting_session_management.util.creator.TopicCreator.createValidTopic;

public class VotingSessionCreator {

    public static VotingSession createValidVotingSession() {
        return VotingSession.builder()
                .id(1L)
                .topic(createValidTopic())
                .build();
    }

    public static VotingSessionDTO createValidVotingSessionDto() {
        return VotingSessionDTO.builder()
                .idTopic(createValidTopic().getId())
                .build();

    }
}
