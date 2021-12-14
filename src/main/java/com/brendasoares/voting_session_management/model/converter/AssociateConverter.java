package com.brendasoares.voting_session_management.model.converter;

import com.brendasoares.voting_session_management.model.dto.AssociateDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;

public class AssociateConverter {

    public static Associate toEntity(AssociateDTO associateDTO){
        return new Associate(associateDTO.getUserName());
    }
}
