package com.brendasoares.voting_session_management.util.creator;

import com.brendasoares.voting_session_management.model.entity.Topic;

public class TopicCreator {

    public static Topic createValidTopic() {
        return Topic.builder()
                .id(1L)
                .title("Mais diversidade na TI")
                .description("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit...")
                .build();
    }
}
