package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.exception.AssociateNotFoundException;
import com.brendasoares.voting_session_management.model.converter.AssociateConverter;
import com.brendasoares.voting_session_management.model.dto.AssociateDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.repository.AssociateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociateService {

    private final AssociateRepository associateRepository;

    public AssociateService(AssociateRepository associateRepository) {
        this.associateRepository = associateRepository;
    }

    public void addAssociate(AssociateDTO associateDTO) {
        Associate associate = AssociateConverter.toEntity(associateDTO);
        associateRepository.save(associate);
    }

    public List<Associate> getAllAssociate() {
        return associateRepository.findAll();
    }

    public Associate getAssociateById(Long id) {
        return associateRepository.findById(id).orElseThrow(AssociateNotFoundException::new);
    }




}
