package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Exercise;
import org.utopia.fitnessdb.repository.ExerciseRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public Exercise getExerciseById(Integer id) throws EntityNotFoundException {
        Optional<Exercise> result = exerciseRepository.findById(id);
        if (result.isEmpty()) {
            throw new EntityNotFoundException("Exercise (" + id + ") not found");
        }
        return result.get();
    }
}
