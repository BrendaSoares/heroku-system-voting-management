package com.brendasoares.voting_session_management.model.converter;

import com.brendasoares.voting_session_management.model.dto.TopicDTO;
import com.brendasoares.voting_session_management.model.entity.Topic;

public class TopicConverter {

    public static Topic toEntity(TopicDTO topicDTO){
        return new Topic(topicDTO.getTitle(), topicDTO.getDescription());
    }
}
