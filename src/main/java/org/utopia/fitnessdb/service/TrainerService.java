package com._4900.utopia.service;

import com._4900.utopia.dto.TrainerDTO;
import com._4900.utopia.model.Trainer;
import com._4900.utopia.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service 
public class TrainerService {
    private final TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    public Optional<Trainer> getTrainerById(Integer id) {
        return trainerRepository.findById(id);
    }

    public List<Trainer> searchTrainersByName(String name) {
        return trainerRepository.findByNameContainingIgnoreCase(name);
    }   
}
