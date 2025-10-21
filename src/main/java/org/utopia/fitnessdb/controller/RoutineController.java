package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.RoutineDto;
import org.utopia.fitnessdb.mapper.RoutineDtoMapper;
import org.utopia.fitnessdb.service.RoutineService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "routine",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)
public class RoutineController {
    private final RoutineDtoMapper m_mapper;
    private final RoutineService m_service;

    @GetMapping
    ResponseEntity<List<RoutineDto>> getAllRoutines() {
        return new ResponseEntity<>(m_mapper.toDtoList(m_service.getAllRoutines()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<RoutineDto> getRoutineById(@PathVariable Integer id) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getRoutineById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "name/{name}")
    ResponseEntity<RoutineDto> getRoutineByName(@PathVariable String name) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getRoutineByName(name)), HttpStatus.OK);
    }
}
