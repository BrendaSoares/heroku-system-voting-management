package com.brendasoares.voting_session_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TopicNotFoundException extends ResponseStatusException {

    public static final String TOPIC_NOT_FOUND_ERROR = "Topic not Found.";

    public TopicNotFoundException(){
        super(HttpStatus.NOT_FOUND, TOPIC_NOT_FOUND_ERROR);
    }
}
