package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.repository.TrainerRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository m_repository;

    public List<Trainer> getAllTrainers() {
        return m_repository.findAll();
    }

    public Trainer getTrainerById(Integer id) throws EntityNotFoundException {
        Optional<Trainer> trainer = m_repository.findById(id);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with ID " + id + " not found");
        }
        return trainer.get();
    }

    public Trainer getTrainerByEmail(String email) throws EntityNotFoundException {
        Optional<Trainer> trainer = m_repository.findByEmail(email);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with email " + email + " not found");
        }
        return trainer.get();
    }
}
