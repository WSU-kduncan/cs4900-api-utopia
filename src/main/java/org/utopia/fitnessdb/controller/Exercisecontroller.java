package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.utopia.fitnessdb.controller.Routinecontroller;
import org.utopia.fitnessdb.controller.Exercisecontroller;

import org.utopia.fitnessdb.dto.Routinedto;
import org.utopia.fitnessdb.dto.Exercisedto;

import org.utopia.fitnessdb.mapper.Routinedtomapper;
import org.utopia.fitnessdb.mapper.Exercisedtomapper;

import org.utopia.fitnessdb.repository.Routinerepository;
import org.utopia.fitnessdb.repository.Exerciserepository;

import org.utopia.fitnessdb.service.Exerciseservice;
import org.utopia.fitnessdb.service.Routineservice;

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
