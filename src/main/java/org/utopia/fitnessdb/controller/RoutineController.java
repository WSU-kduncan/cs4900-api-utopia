package org.utopia.fitnessdb.controller;

<<<<<<<HEAD

import java.util.List;

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

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "routine",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class RoutineController {

    private final RoutineDtoMapper routineDtoMapper;

    private final RoutineService routineService;

<<<<<<< HEAD
    @GetMapping
    ResponseEntity<List<RoutineDto>> getAllRoutine() {
        return new ResponseEntity<>(
                routineDtoMapper.toDtoList(routineService.getAllRoutine()), HttpStatus.OK);
    }
=======
  @GetMapping
  // rename to getAllRoutines for a better clarity
  ResponseEntity<List<RoutineDto>> getAllRoutines() {
    return new ResponseEntity<>(
        routineDtoMapper.toDtoList(routineService.getAllRoutines()), HttpStatus.OK);
  }
>>>>>>> 0a354767b73d047550c6a29f4f4694475de97e2c

    @GetMapping(path = "{id}")
    ResponseEntity<RoutineDto> getRoutineById(@PathVariable Integer id) {
        return new ResponseEntity<>(
                routineDtoMapper.toDto(routineService.getRoutineById(id)), HttpStatus.OK);
    }
}
