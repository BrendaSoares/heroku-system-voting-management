package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.exception.TopicNotFoundException;
import com.brendasoares.voting_session_management.model.converter.TopicConverter;
import com.brendasoares.voting_session_management.model.dto.TopicDTO;
import com.brendasoares.voting_session_management.model.entity.Topic;
import com.brendasoares.voting_session_management.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public void save(TopicDTO topicDTO) {
        Topic topic = TopicConverter.toEntity(topicDTO);
        topicRepository.save(topic);
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id).orElseThrow(TopicNotFoundException::new);
    }

    public void deleteTopicById(Long id) {
        topicRepository.deleteById(id);
    }
}
