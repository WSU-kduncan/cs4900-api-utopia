package org.utopia.fitnessdb.service;

import org.utopia.fitnessdb.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.repository.ExerciseRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExerciseService {

  private final ExerciseRepository exerciseRepository;

  public List<Exercise> getAllExercise() {
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
