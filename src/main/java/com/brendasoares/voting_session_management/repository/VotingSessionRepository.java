package com.brendasoares.voting_session_management.repository;

import com.brendasoares.voting_session_management.model.entity.VotingSession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotingSessionRepository extends CrudRepository<VotingSession, Long> {

    List<VotingSession> findAll();
}