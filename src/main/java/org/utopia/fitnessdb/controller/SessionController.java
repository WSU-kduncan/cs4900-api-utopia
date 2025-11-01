package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.SessionDto;
import org.utopia.fitnessdb.mapper.SessionDtoMapper;
import org.utopia.fitnessdb.service.SessionService;

import jakarta.persistence.criteria.Path;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "session", produces = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {
    private final SessionDtoMapper sessionDtoMapper;
    private final SessionService sessionService;

    // get all session
    @GetMapping
    ResponseEntity<List<SessionDto>> getAllSessions() {
        return new ResponseEntity<>(
                sessionDtoMapper.toDtoList(sessionService.getAllSessions()), HttpStatus.OK);
    }

    // get session by id
    @GetMapping(path = "{id}")
    ResponseEntity<SessionDto> getSessionById(@PathVariable Integer id) {
        return new ResponseEntity<>(
                sessionDtoMapper.toDto(sessionService.getSessionById(id)), HttpStatus.OK);
    }
 
    // get session by date
    @GetMapping(path = "date")
    ResponseEntity<List<SessionDto>> getSessionByDate(@RequestParam String date) {
        java.sql.Date parsedDate = java.sql.Date.valueOf(date); 
        List<SessionDto> sessions = sessionDtoMapper.toDtoList(sessionService.getSessionByDate(parsedDate));
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }

    // get session by trainer
    @GetMapping(path = "trainer/{trainer}")
    ResponseEntity<SessionDto> getSessionByTrainer(@PathVariable Integer trainer) {
        return new ResponseEntity<>(
            sessionDtoMapper.toDto(sessionService.getSessionByTrainer(trainer)), HttpStatus.OK);
    }

    // get session by client
    @GetMapping(path = "client/{client}")
    ResponseEntity<SessionDto> getSessionByClient(@PathVariable Integer client) {
        return new ResponseEntity<>(
            sessionDtoMapper.toDto(sessionService.getSessionByClient(client)), HttpStatus.OK);
    }
 
    // POST
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SessionDto> createSession(@RequestBody SessionDto sessionDto) {
        SessionDto created = sessionDtoMapper.toDto(sessionService.createSession(sessionDtoMapper.toEntity(sessionDto)));
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    // PUT 
    @PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<SessionDto> updateSession(@PathVariable Integer id, @RequestBody SessionDto sessionDto) {
        SessionDto updated = sessionDtoMapper.toDto(sessionService.updateSession(id, sessionDtoMapper.toEntity(sessionDto)));
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    
}
