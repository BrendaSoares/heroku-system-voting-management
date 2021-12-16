package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.model.dto.VotingSessionDTO;
import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.model.entity.VotingSession;
import com.brendasoares.voting_session_management.repository.VotingSessionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VotingSessionServiceTest {

    @InjectMocks
    private VotingSessionService votingSessionService;
    @Mock
    private VotingSessionRepository votingSessionRepository;

    final ArrayList<VotingSession> votingSessionArrayList = new ArrayList<>();
    private final Topic topicExample = new Topic("Topic", "example description");
    private final VotingSession votingSessionExample = new VotingSession(topicExample);


  @Test
	@DisplayName("getAll returns list of associate when successful")
	void getAll_ReturnListAssociate_WhenSuccessful() {
		when(votingSessionRepository.findAll())
				.thenReturn(votingSessionArrayList);
	}

	@Test
	void save_CreateAssociate_WhenSuccessful() {
		when(votingSessionRepository.save(any())).thenReturn(votingSessionExample);
	}

    @Test
    void getById_ReturnVotingSessionById_WhenSuccessful() {


        when(votingSessionRepository.findById(any())).
                thenReturn(Optional.of(votingSessionExample));
        assertEquals(votingSessionExample.getId(), votingSessionService.getVotingSessionById(1L).getId());
    }

    @Test
    void getById_AssociateNotFound_WhenAssociateNotFoundException() {
        when(votingSessionRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertEquals(NOT_FOUND, assertThrows(ResponseStatusException.class, () -> votingSessionService.getVotingSessionById(15L)).getStatus());
    }
}
