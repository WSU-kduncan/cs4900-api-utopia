package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.utopia.fitnessdb.dto.SessionDto;
import org.utopia.fitnessdb.mapper.SessionMapper;
import org.utopia.fitnessdb.model.Session;
import org.utopia.fitnessdb.service.SessionService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sessions")
@RequiredArgsConstructor
public class SessionController {

    private final SessionService sessionService;
    private final SessionMapper sessionMapper;

    // 1️⃣ Find all sessions
    @GetMapping
    public ResponseEntity<List<SessionDto>> getAllSessions() {
        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDto> dtos = sessions.stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // 2️⃣ Find session by ID
    @GetMapping("/{id}")
    public ResponseEntity<SessionDto> getSessionById(@PathVariable Integer id) {
        Optional<Session> sessionOpt = sessionService.getSessionById(id);
        return sessionOpt
                .map(session -> ResponseEntity.ok(sessionMapper.toDto(session)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 3️⃣ Search sessions by note
    @GetMapping("/search")
    public ResponseEntity<List<SessionDto>> searchSessions(@RequestParam String note) {
        List<Session> sessions = sessionService.searchSessionsByNote(note);
        List<SessionDto> dtos = sessions.stream()
                .map(sessionMapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
