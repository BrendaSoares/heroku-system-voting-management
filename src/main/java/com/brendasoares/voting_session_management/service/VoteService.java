package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.model.converter.VoteConverter;
import com.brendasoares.voting_session_management.model.dto.VoteDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.model.entity.Vote;
import com.brendasoares.voting_session_management.model.entity.VotingSession;
import com.brendasoares.voting_session_management.repository.VoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteService {

    private final VoteRepository voteRepository;
    private final AssociateService associateService;
    private final VotingSessionService votingSessionService;

    public VoteService(VoteRepository voteRepository, AssociateService associateService, VotingSessionService votingSessionService) {
        this.voteRepository = voteRepository;
        this.associateService = associateService;
        this.votingSessionService = votingSessionService;
    }

    public List<VoteDTO> getAllVotes() {
        return voteRepository.findAll().stream().map(VoteConverter::toDTO).collect(Collectors.toList());
    }

    public void save(VoteDTO voteDTO) {

        Associate foundAssociate = associateService.getAssociateById(voteDTO.getIdAssociate());
        VotingSession foundVotingSession = votingSessionService.getVotingSessionById(voteDTO.getIdVotingsession());
        Vote vote = VoteConverter.toEntity(foundVotingSession, foundAssociate, voteDTO);

        voteRepository.save(vote);
    }

    public String getResultVotingSession(Long idVotingSession) {

        VotingSession foundVotingSession = votingSessionService.getVotingSessionById(idVotingSession);
        List<Vote> votes = foundVotingSession.getVotes();

        long numberOfVotesYes = votes.stream().filter(Vote::getChoice).count();
        long numberOfvotesNo = votes.stream().filter(vote -> !vote.getChoice()).count();
        return "VOTES (YES) = " + numberOfVotesYes + "\nVOTES (NO) = " + numberOfvotesNo;
    }
}

