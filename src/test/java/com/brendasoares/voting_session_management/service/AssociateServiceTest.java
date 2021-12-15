package com.brendasoares.voting_session_management.service;

import com.brendasoares.voting_session_management.model.dto.AssociateDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.model.entity.Vote;
import com.brendasoares.voting_session_management.repository.AssociateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import static com.brendasoares.voting_session_management.util.creator.AssociateCreator.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(SpringExtension.class)
class AssociateServiceTest {

	@InjectMocks
	private AssociateService associateService;
	@Mock
	private AssociateRepository associateRepository;

	private final Associate validAssociate = createAssociateValid();
	private final AssociateDTO validAssociateDto = createAssociateDtoValid();

//	final ArrayList<Associate> associatesArrayList = new ArrayList<>();


//	@Test
//	@DisplayName("getAll returns list of associate when successful")
//	void getAll_ReturnListAssociate_WhenSuccessful() {
//		when(associateRepository.findAll(any(List<Associate>)))
//				.thenReturn(associatesArrayList);
//	}

//	@Test
//	void save_CreateAssociate_WhenSuccessful() {
//		when(associateRepository.save(any())).thenReturn(validAssociate);
//		assertEquals(validAssociateDto, associateService.addAssociate(validAssociateDto));
//	}

	@Test
	void getById_ReturnAssociate_WhenSuccessful() {
		when(associateRepository.findById(any())).
				thenReturn(Optional.of(validAssociate));
		assertEquals(validAssociate.getId(), associateService.getAssociateById(1L).getId());
	}

	@Test
	void getById_AssociateNotFound_WhenAssociateNotFoundException() {
		when(associateRepository.findById(any()))
				.thenReturn(Optional.empty());
		assertEquals(NOT_FOUND, assertThrows(ResponseStatusException.class, () -> associateService.getAssociateById(13L)).getStatus());
	}

}
