package com.brendasoares.voting_session_management.service;


import com.brendasoares.voting_session_management.exception.VotingNotFoundSessionException;
import com.brendasoares.voting_session_management.model.converter.VotingSessionConverter;
import com.brendasoares.voting_session_management.model.dto.VotingSessionDTO;
import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.model.entity.VotingSession;
import com.brendasoares.voting_session_management.repository.VotingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VotingSessionService {

    private final VotingSessionRepository votingSessionRepository;

    private final TopicService topicService;

    public VotingSessionService(VotingSessionRepository votingSessionRepository, TopicService topicService) {
        this.votingSessionRepository = votingSessionRepository;
        this.topicService = topicService;
    }

    public List<VotingSession> getAllVotingSession() {
        return votingSessionRepository.findAll();
    }

    public void save(VotingSessionDTO votingSessionDTO) {

        Topic foundTopic = topicService.getTopicById(votingSessionDTO.getIdTopic());
        VotingSession votingSession = VotingSessionConverter.toEntity(foundTopic);

        votingSessionRepository.save(votingSession);
    }

    public VotingSession getVotingSessionById(Long id) {
        return votingSessionRepository.findById(id).orElseThrow(VotingNotFoundSessionException::new);
    }

}
