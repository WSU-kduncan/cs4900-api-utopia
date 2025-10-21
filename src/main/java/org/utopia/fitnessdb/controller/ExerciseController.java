package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.controller.ExerciseController;
import org.utopia.fitnessdb.dto.ExerciseDto;
import org.utopia.fitnessdb.mapper.ExerciseDtoMapper;
import org.utopia.fitnessdb.repository.ExerciseRepository;
import org.utopia.fitnessdb.service.ExerciseService;
import org.utopia.fitnessdb.model.Exercise;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "exercise",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class ExerciseController {

  private final ExerciseDtoMapper exerciseDtoMapper;

  private final ExerciseService exerciseService;

  @GetMapping
  ResponseEntity<List<ExerciseDto>> getAllExercise() {
    return new ResponseEntity<>(
        ExerciseDtoMapper.toDtoList(exerciseService.getAllExercise()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<ExerciseDto> getExerciseById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        ExerciseDtoMapper.toDto(exerciseService.getExerciseById(id)), HttpStatus.OK);
  }
}
