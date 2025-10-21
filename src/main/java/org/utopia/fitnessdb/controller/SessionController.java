package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.SessionDto;
import org.utopia.fitnessdb.mapper.SessionDtoMapper;
import org.utopia.fitnessdb.service.SessionService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "session",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class SessionController {
    private final SessionDtoMapper m_mapper;
    private final SessionService m_service;

    @GetMapping
    ResponseEntity<List<SessionDto>> getAllSessions() {
        return new ResponseEntity<>(m_mapper.toDtoList(m_service.getAllSessions()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<SessionDto> getSessionById(@PathVariable Integer id) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getSessionById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "trainer/{trainer}")
    ResponseEntity<SessionDto> getSessionByTrainer(@PathVariable Integer trainer) {
        return new ResponseEntity<>(
                m_mapper.toDto(m_service.getSessionByTrainer(trainer)), HttpStatus.OK);
    }

    @GetMapping(path = "client/{client}")
    ResponseEntity<SessionDto> getSessionByClient(@PathVariable Integer client) {
        return new ResponseEntity<>(
                m_mapper.toDto(m_service.getSessionByTrainer(client)), HttpStatus.OK);
    }
}
