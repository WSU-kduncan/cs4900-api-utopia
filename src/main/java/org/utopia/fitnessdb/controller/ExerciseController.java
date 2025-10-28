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
    private final ExerciseDtoMapper mapper;
    private final ExerciseService service;

    @GetMapping
    ResponseEntity<List<ExerciseDto>> getAllExercises() {
        return new ResponseEntity<>(mapper.toDtoList(service.getAllExercises()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ExerciseDto> getExerciseById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.toDto(service.getExerciseById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "name/{name}")
    ResponseEntity<ExerciseDto> getExerciseByName(@PathVariable String name) {
        return new ResponseEntity<>(
                mapper.toDto(service.getExerciseByName(name)), HttpStatus.OK);
    }
}
