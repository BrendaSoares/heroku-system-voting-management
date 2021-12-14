package com.brendasoares.voting_session_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VotingNotFoundSessionException extends ResponseStatusException {

    public static final String VOTING_SESSION_NOT_FOUND_ERROR = "Voting Session not Found.";

    public VotingNotFoundSessionException(){
        super(HttpStatus.NOT_FOUND, VOTING_SESSION_NOT_FOUND_ERROR);
    }
}
