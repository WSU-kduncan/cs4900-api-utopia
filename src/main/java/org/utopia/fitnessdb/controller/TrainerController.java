package org.utopia.fitnessdb.controller;

import java.util.List;

import javax.security.auth.login.FailedLoginException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.object.LoginForm;
import org.utopia.fitnessdb.service.TrainerService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "trainer")
public class TrainerController {
    private final TrainerDtoMapper trainerDtoMapper;
    private final TrainerService trainerService;

    @GetMapping
    ResponseEntity<List<TrainerDto>> getAllTrainers() {
        return new ResponseEntity<>(trainerDtoMapper.toDtoList(trainerService.getAllTrainers()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<TrainerDto> getTrainerById(@PathVariable Integer id) {
        return new ResponseEntity<>(trainerDtoMapper.toDto(trainerService.getTrainerById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<TrainerDto> getTrainerByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                trainerDtoMapper.toDto(trainerService.getTrainerByEmail(email)), HttpStatus.OK);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> trainerLogin(@RequestBody LoginForm form) {
        Trainer trainer;
       try {
            trainer = trainerService.trainerLogin(form.getEmail(), form.getPasswordHash());
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (FailedLoginException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(trainerDtoMapper.toDto(trainer), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createTrainer(@RequestBody TrainerDto trainerDto) {
        Trainer trainer;
        try {
            trainer = trainerService.createTrainer(trainerDto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(trainer, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    ResponseEntity<Object> updateClient(@PathVariable("id") Integer id, @RequestBody TrainerDto trainerDto) {
        Trainer trainer;
        try {
            trainer = trainerService.updateTrainer(id, trainerDto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(trainerDtoMapper.toDto(trainer), HttpStatus.OK);
    }
}
