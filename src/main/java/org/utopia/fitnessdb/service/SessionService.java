package org.utopia.fitnessdb.service;

//package service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Session;  
import org.utopia.fitnessdb.repository.SessionRepository;

import java.util.List; 
import java.util.Optional;  

@Service
@RequiredArgsConstructor
public class SessionService {
    private final SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
    
    public Optional<Session> getSessionById(Integer id) {
        return sessionRepository.findById(id);
    }

    public List<Session> searchSessionsByNote(String note) {
        return sessionRepository.findByNoteContainingIgnoreCase(note);
    }
    
}
