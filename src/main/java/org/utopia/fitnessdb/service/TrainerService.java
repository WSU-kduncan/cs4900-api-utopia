package org.utopia.fitnessdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.repository.TrainerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final TrainerDtoMapper trainerDtoMapper;

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

    public Trainer createTrainer(TrainerDto trainerDto) throws EntityNotFoundException {
        return trainerRepository.saveAndFlush(trainerDtoMapper.toEntity(trainerDto));
    }

    public Trainer updateTrainer(Integer id, TrainerDto trainerDto) throws EntityNotFoundException {
        Trainer trainer = trainerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Trainer with ID " + id + " not found"));

        if (trainerDto.getEmail() != null) trainer.setEmail(trainerDto.getEmail());
        if (trainer.getName() != null) trainer.setName(trainerDto.getName());
        if (trainer.getPasswordHash() != null) trainer.setPasswordHash(trainerDto.getPasswordHash());
    
        return trainerRepository.saveAndFlush(trainer);
    }

}
