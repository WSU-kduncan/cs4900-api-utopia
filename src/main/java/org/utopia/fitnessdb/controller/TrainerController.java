package org.utopia.fitnessdb.controller;

import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.service.TrainerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(
    path = "trainer",
    produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)

public class TrainerController {

    private final TrainerDtoMapper trainerMapper;

    private final TrainerService trainerService;

    @GetMapping
    ResponseEntity<List<TrainerDto>> getAllTrainers() {
        return new ResponseEntity<>(
            trainerMapper.toDtoList(trainerService.getAllTrainers()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<TrainerDto> getTrainerById(@PathVariable Integer id) {
        return new ResponseEntity<>(
        trainerMapper.toDto(trainerService.getTrainerById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<TrainerDto> getTrainerByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
        trainerMapper.toDto(trainerService.getTrainerByEmail(email)), HttpStatus.OK);
    }
}
