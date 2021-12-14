package com.brendasoares.voting_session_management.controller;

import com.brendasoares.voting_session_management.model.dto.TopicDTO;
import com.brendasoares.voting_session_management.model.dto.VoteDTO;
import com.brendasoares.voting_session_management.model.dto.VotingSessionDTO;
import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.model.entity.VotingSession;
import com.brendasoares.voting_session_management.service.TopicService;
import com.brendasoares.voting_session_management.service.VoteService;
import com.brendasoares.voting_session_management.service.VotingSessionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/topic")
@CrossOrigin(origins = "*")
public class TopicController {

    private final TopicService topicService;
    private final VotingSessionService votingSessionService;
    private final VoteService voteService;

    public TopicController(TopicService topicService, VotingSessionService votingSessionService, VoteService voteService) {
        this.topicService = topicService;
        this.votingSessionService = votingSessionService;
        this.voteService = voteService;
    }


    @GetMapping
    @ApiOperation("List Topics")
    public ResponseEntity<List<Topic>> listTopic() {
        return ResponseEntity.ok()
                .body(topicService.getAllTopic());
    }

    @GetMapping("/votingSession")
    @ApiOperation("List Voting Sessions")
    public ResponseEntity<List<VotingSession>> listVotingSession() {
        return ResponseEntity.ok()
                .body(votingSessionService.getAllVotingSession());
    }

    @GetMapping("/votingSession/vote")
    @ApiOperation("List Votes")
    public ResponseEntity<List<VoteDTO>> listVote() {
        return ResponseEntity.ok()
                .body(voteService.getAllVotes());
    }

    @GetMapping("/votingSession/vote/result/{idVotingSession}")
    @ApiOperation("Result of Votes")
    public ResponseEntity<String> getResultOfVotingSession(@PathVariable Long idVotingSession) {
        return ResponseEntity.ok().body(voteService.getResultVotingSession(idVotingSession));
    }

    @PostMapping
    @ApiOperation("Add New Topic")
    public ResponseEntity<String> create(@RequestBody @Valid TopicDTO topicDTO) {
        topicService.save(topicDTO);
        return ResponseEntity.ok().body("Topic successfully added!");
    }

    @PostMapping("/votingSession")
    @ApiOperation("Add new Voting Session")
    public ResponseEntity<String> insertVotingSession(@RequestBody @Valid VotingSessionDTO votingSessionDTO) {
        votingSessionService.save(votingSessionDTO);
        return ResponseEntity.ok().body("Voting Session successfully added!");
    }

    @PostMapping("/votingSession/vote")
    @ApiOperation("Add new Vote")
    public ResponseEntity<String> insertVotingSession(@RequestBody @Valid VoteDTO voteDTO) {
        voteService.save(voteDTO);
        return ResponseEntity.ok().body("Vote successfully added!");
    }
}
