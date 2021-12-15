package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.repository.TopicRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static com.brendasoares.voting_session_management.util.creator.TopicCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TopicServiceTest {

    @InjectMocks
    private TopicService topicService;
    @Mock
    private TopicRepository topicRepository;

    private final Topic validTopic = createValidTopic();

    @Test
    void getById_ReturnAssociate_WhenSuccessful() {
        when(topicRepository.findById(any())).
                thenReturn(Optional.of(validTopic));
        assertEquals(validTopic.getId(), topicService.getTopicById(1L).getId());
    }

    @Test
    void getById_AssociateNotFound_WhenAssociateNotFoundException() {
        when(topicRepository.findById(any()))
                .thenReturn(Optional.empty());
        assertEquals(NOT_FOUND, assertThrows(ResponseStatusException.class, () -> topicService.getTopicById(13L)).getStatus());
    }
}
