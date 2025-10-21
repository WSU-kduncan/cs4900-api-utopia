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
    private final ExerciseRepository m_repository;

    public List<Exercise> getAllExercises() {
        return m_repository.findAll();
    }

    public Exercise getExerciseById(Integer id) throws EntityNotFoundException {
        Optional<Exercise> exercise = m_repository.findById(id);
        if (exercise.isEmpty()) {
            throw new EntityNotFoundException("Exercise with ID " + id + " not found");
        }
        return exercise.get();
    }

    public Exercise getExerciseByName(String name) throws EntityNotFoundException {
        Optional<Exercise> exercise = m_repository.findByName(name);
        if (exercise.isEmpty()) {
            throw new EntityNotFoundException("Exercise with name " + name + " not found");
        }
        return exercise.get();

    }
}
