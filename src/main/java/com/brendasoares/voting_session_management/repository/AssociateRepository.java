package com.brendasoares.voting_session_management.repository;


import com.brendasoares.voting_session_management.model.entity.Associate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssociateRepository extends CrudRepository<Associate, Long> {

    List<Associate> findAll();
}
