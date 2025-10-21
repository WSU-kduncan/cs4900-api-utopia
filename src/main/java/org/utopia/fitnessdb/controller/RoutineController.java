
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
import org.utopia.fitnessdb.dto.RoutineDto;
import org.utopia.fitnessdb.mapper.RoutineDtoMapper;
import org.utopia.fitnessdb.repository.RoutineRepository;
import org.utopia.fitnessdb.service.RoutineService;
import org.utopia.fitnessdb.model.Routine;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "routine",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
public class RoutineController {

  private final RoutineDtoMapper routineDtoMapper;

  private final RoutineService routineService;

  @GetMapping
  ResponseEntity<List<RoutineDto>> getAllRoutine() {
    return new ResponseEntity<>(
        routineDtoMapper.toDtoList(routineService.getAllRoutine()), HttpStatus.OK);
  }

  @GetMapping(path = "{id}")
  ResponseEntity<RoutineDto> getRoutineById(@PathVariable Integer id) {
    return new ResponseEntity<>(
        routineDtoMapper.toDto(routineService.getRoutineById(id)), HttpStatus.OK);
  }
}
