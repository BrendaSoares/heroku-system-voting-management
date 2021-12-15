package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.model.dto.VotingSessionDTO;
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
import java.util.Optional;

import static com.brendasoares.voting_session_management.util.creator.VotingSessionCreator.*;
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

    private final VotingSession validVotingSession = createValidVotingSession();
    private final VotingSessionDTO validVotingSessionDto = createValidVotingSessionDto();
    final ArrayList<VotingSession> votingSessionArrayList = new ArrayList<>();


//  @Test
//	@DisplayName("getAll returns list of associate when successful")
//	void getAll_ReturnListAssociate_WhenSuccessful() {
//		when(votingSessionRepository.findAll(any(List<VotingSession>)))
//				.thenReturn(votingSessionArrayList);
//	}

//	@Test
//	void save_CreateAssociate_WhenSuccessful() {
//		when(votingSessionRepository.save(any())).thenReturn(validVotingSession);
//		assertEquals(validVotingSessionDto, votingSessionService.save(validVotingSessionDto));
//	}

    @Test
    void getById_ReturnAssociate_WhenSuccessful() {
        when(votingSessionRepository.findById(any())).
                thenReturn(Optional.of(validVotingSession));
        assertEquals(validVotingSession.getId(), votingSessionService.getVotingSessionById(1L).getId());
    }

    @Test
    void getById_AssociateNotFound_WhenAssociateNotFoundException() {
        when(votingSessionRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertEquals(NOT_FOUND, assertThrows(ResponseStatusException.class, () -> votingSessionService.getVotingSessionById(15L)).getStatus());
    }
}
