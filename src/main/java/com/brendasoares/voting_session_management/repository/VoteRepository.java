package com.brendasoares.voting_session_management.repository;


import com.brendasoares.voting_session_management.model.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends CrudRepository<Vote, Long> {

    List<Vote> findAll();

}
