package com.brendasoares.voting_session_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AssociateNotFoundException extends ResponseStatusException {

    public static final String ASSOCIATE_NOT_FOUND_ERROR = "Associate not Found.";

    public AssociateNotFoundException(){
        super(HttpStatus.NOT_FOUND, ASSOCIATE_NOT_FOUND_ERROR);
    }
}
