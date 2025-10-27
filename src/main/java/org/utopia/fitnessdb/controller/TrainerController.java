package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.service.TrainerService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "trainer",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)

public class TrainerController {
    
    private final TrainerDtoMapper m_mapper;
    private final TrainerService m_service;

    @GetMapping
    ResponseEntity<List<TrainerDto>> getAllTrainers() {
        return new ResponseEntity<>(m_mapper.toDtoList(m_service.getAllTrainers()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<TrainerDto> getTrainerById(@PathVariable Integer id) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getTrainerById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<TrainerDto> getTrainerByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                m_mapper.toDto(m_service.getTrainerByEmail(email)), HttpStatus.OK);
    }

}
