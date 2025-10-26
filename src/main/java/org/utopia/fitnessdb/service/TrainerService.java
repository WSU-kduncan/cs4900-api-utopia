package org.utopia.fitnessdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.repository.TrainerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Trainer getTrainerById(Integer id) throws EntityNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findById(id);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with ID " + id + " not found");
        }
        return trainer.get();
    }

    public Trainer getTrainerByEmail(String email) throws EntityNotFoundException {
        Optional<Trainer> trainer = trainerRepository.findByEmail(email);
        if (trainer.isEmpty()) {
            throw new EntityNotFoundException("Trainer with email " + email + " not found");
        }
        return trainer.get();
    }
}
