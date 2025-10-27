package org.utopia.fitnessdb.service;

import java.util.List;
import java.util.Optional;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Routine;
import org.utopia.fitnessdb.repository.RoutineRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoutineService {

  private final RoutineRepository routineRepository;

  // Reaname to getAllRoutines for better clarity
  public List<Routine> getAllRoutines() {
    return routineRepository.findAll();
  }

  public Routine getRoutineById(Integer id) throws EntityNotFoundException {
    // rename result to routine
    Optional<Routine> routine = routineRepository.findById(id);
    if (routine.isEmpty()) {
      throw new EntityNotFoundException("Routine (" + id + ") not found");
    }
    return routine.get();
  }

  // write one for getRoutineByName
  public Routine getRoutineByName(String name) throws EntityNotFoundException {
    // rename result to routine
    Optional<Routine> routine = routineRepository.findByName(name);
    if (routine.isEmpty()) {
      throw new EntityNotFoundException("Routine (" + name + ") not found");
    }
    return routine.get();
  }>>>>>>>0 a354767b73d047550c6a29f4f4694475de97e2c
}
