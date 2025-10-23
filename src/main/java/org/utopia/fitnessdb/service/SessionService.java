package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;
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
    
    public Session getSessionById(Integer id) throws EntityNotFoundException {
        Optional<Session> session = sessionRepository.findById(id); 
        if (session.isEmpty()) {
            throw new EntityNotFoundException("Session with ID " + id + " not found");
        }
        return session.get(); 
    }
    
    
}
