package com.brendasoares.voting_session_management.model.converter;

import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.model.entity.VotingSession;

public class VotingSessionConverter {

    public static VotingSession toEntity(Topic foundTopic){
        return new VotingSession(foundTopic);
    }
}
