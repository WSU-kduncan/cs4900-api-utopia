package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.ExerciseDto;
import org.utopia.fitnessdb.mapper.ExerciseDtoMapper;
import org.utopia.fitnessdb.service.ExerciseService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "exercise",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ExerciseController {
    private final ExerciseDtoMapper m_mapper;
    private final ExerciseService m_service;

    @GetMapping
    ResponseEntity<List<ExerciseDto>> getAllExercises() {
        return new ResponseEntity<>(m_mapper.toDtoList(m_service.getAllExercises()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ExerciseDto> getExerciseById(@PathVariable Integer id) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getExerciseById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "name/{name}")
    ResponseEntity<ExerciseDto> getExerciseByName(@PathVariable String name) {
        return new ResponseEntity<>(
                m_mapper.toDto(m_service.getExerciseByName(name)), HttpStatus.OK);
    }
}
