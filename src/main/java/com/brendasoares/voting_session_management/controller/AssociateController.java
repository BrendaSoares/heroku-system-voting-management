package com.brendasoares.voting_session_management.controller;


import com.brendasoares.voting_session_management.model.dto.AssociateDTO;
import com.brendasoares.voting_session_management.model.entity.Associate;
import com.brendasoares.voting_session_management.service.AssociateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/associateManagement")
@CrossOrigin(origins = "*")
public class AssociateController {

    private final AssociateService associateService;

    public AssociateController(AssociateService associateService) {
        this.associateService = associateService;
    }

    @PostMapping
    @ApiOperation("Add Associate")
    public
    ResponseEntity<String> add(@RequestBody @Valid AssociateDTO associateDTO) {
        associateService.addAssociate(associateDTO);
        return ResponseEntity.ok().body("Associate successfully added!");
    }

    @GetMapping
    @ApiOperation("List Associate")
    public ResponseEntity<List<Associate>> list() {
        return ResponseEntity.ok()
                .body(associateService.getAllAssociate());
    }
}
