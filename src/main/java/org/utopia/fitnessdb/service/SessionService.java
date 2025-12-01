package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Session;
import org.utopia.fitnessdb.repository.SessionRepository;

import java.sql.Date;
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
            throw new EntityNotFoundException("Session with ID: " + id + " not found");
        }
        return session.get();
    }

    public List<Session> getSessionByTrainer(Integer trainer) throws EntityNotFoundException {
        List<Session> sessions = sessionRepository.findByTrainerId(trainer);
        if (sessions.isEmpty()) {
            throw new EntityNotFoundException("No sessions found for trainer ID " + trainer);
        }
        return sessions;
    }

    public List<Session> getSessionByClient(Integer client) throws EntityNotFoundException {
        List<Session> sessions = sessionRepository.findByClientId(client);
        if (sessions.isEmpty()) {
            throw new EntityNotFoundException("Session with client ID " + client + " not found");
        }
        return sessions;
    }

    public List<Session> getSessionByDate(Date date) {
        return sessionRepository.findByDate(date);
    }

    public Session createSession(Session entity) {
        return sessionRepository.save(entity);

    }

    public void deleteSession(Integer id) {
        sessionRepository.deleteById(id);
    }

    public Session updateSession(Integer id, Session update) throws EntityNotFoundException {
        Session existingSession = sessionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Session with ID: " + id + " not found"));

        // Only update fields that are not null
        if (update.getDate() != null) existingSession.setDate(update.getDate());
        if (update.getDuration() != null) existingSession.setDuration(update.getDuration());
        if (update.getNote() != null) existingSession.setNote(update.getNote());
        if (update.getTrainer() != null) existingSession.setTrainer(update.getTrainer());
        if (update.getClient() != null) existingSession.setClient(update.getClient());
        if (update.getRoutine() != null) existingSession.setRoutine(update.getRoutine());

        return sessionRepository.save(existingSession);
    }
}
