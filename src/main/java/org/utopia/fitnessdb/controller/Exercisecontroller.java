package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.utopia.fitnessdb.controller.RoutineController;
import org.utopia.fitnessdb.controller.ExerciseController;

import org.utopia.fitnessdb.dto.RoutineDto;
import org.utopia.fitnessdb.dto.ExerciseDto;

import org.utopia.fitnessdb.mapper.RoutineDtoMapper;
import org.utopia.fitnessdb.mapper.ExerciseDtoMapper;

import org.utopia.fitnessdb.repository.RoutineRepository;
import org.utopia.fitnessdb.repository.ExerciseRepository;

import org.utopia.fitnessdb.service.ExerciseService;
import org.utopia.fitnessdb.service.RoutineService;

import org.utopia.fitnessdb.model.Exercise;
import org.utopia.fitnessdb.model.Routine;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "exercise",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class Exercisecontroller {

  private final Exercisedtomapper exercisedtomapper;

  private final Exerciseservice exerciseservice;

  @GetMapping
  ResponseEntity<List<Exercisedto>> getAllExercise() {
    return new ResponseEntity<>(
        ExercisedtoMapper.toDtoList(exerciseservice.getAllExercise()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<Exercisedto> getExerciseById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        Exercisedtomapper.toDto(exerciseservice.getExerciseById(id)), HttpStatus.OK);
  }
}
