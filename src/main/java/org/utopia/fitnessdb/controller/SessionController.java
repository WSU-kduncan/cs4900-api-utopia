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
import jakarta.websocket.Session;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "session",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE
)

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
    
}


