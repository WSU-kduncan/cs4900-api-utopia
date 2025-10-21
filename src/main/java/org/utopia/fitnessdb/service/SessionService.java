package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Session;
import org.utopia.fitnessdb.repository.SessionRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SessionService {
    private final SessionRepository m_repository;

    public List<Session> getAllSessions() {
        return m_repository.findAll();
    }

    public Session getSessionById(Integer id) throws EntityNotFoundException {
        Optional<Session> session = m_repository.findById(id);
        if (session.isEmpty()) {
            throw new EntityNotFoundException("Session with ID " + id + " not found");
        }
        return session.get();
    }

    public Session getSessionByTrainer(Integer trainer) throws EntityNotFoundException {
        Optional<Session> session = m_repository.findByTrainerId(trainer);
        if (session.isEmpty()) {
            throw new EntityNotFoundException("Session with trainer ID " + trainer + " not found");
        }
        return session.get();
    }

    public Session getSessionByClient(Integer client) throws EntityNotFoundException {
        Optional<Session> session = m_repository.findByClientId(client);
        if (session.isEmpty()) {
            throw new EntityNotFoundException("Session with client ID " + client + " not found");
        }
        return session.get();
    }
}
