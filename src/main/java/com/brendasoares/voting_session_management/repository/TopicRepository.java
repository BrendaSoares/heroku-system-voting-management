package com.brendasoares.voting_session_management.repository;

import com.brendasoares.voting_session_management.model.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    List<Topic> findAll();

}