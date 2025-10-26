package org.utopia.fitnessdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Routine;
import org.utopia.fitnessdb.repository.RoutineRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoutineService {

  private final RoutineRepository routineRepository;

  // Reaname to getAllRoutines for better clarity
  public List<Routine> getAllRoutine() {
    return routineRepository.findAll();
  }

  public Routine getRoutineById(Integer id) throws EntityNotFoundException {
    // rename result to routine
    Optional<Routine> result = routineRepository.findById(id);
    if (result.isEmpty()) {
      throw new EntityNotFoundException("Routine (" + id + ") not found");
    }
    return result.get();
  }

  // write one for getRoutineByName
}
