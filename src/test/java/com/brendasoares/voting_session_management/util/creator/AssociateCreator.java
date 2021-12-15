package com.brendasoares.voting_session_management.util.creator;

import com.brendasoares.voting_session_management.model.dto.AssociateDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.model.entity.Vote;

import java.util.ArrayList;

public class AssociateCreator {

    private static final ArrayList<Vote> voteArrayList = new ArrayList<>();

    public static AssociateDTO createAssociateDtoValid() {
        return AssociateDTO.builder()
                .userName("Joao")
                .build();

    }

    public static Associate createAssociateValid() {
        return Associate.builder()
                .id(1L)
                .userName("Joao")
                .votes(voteArrayList)
                .build();

    }
}
