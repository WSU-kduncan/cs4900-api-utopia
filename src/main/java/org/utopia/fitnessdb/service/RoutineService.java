
package org.utopia.fitnessdb.service;

import org.utopia.fitnessdb.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.repository.RoutineRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RoutineService {

  private final RoutineRepository routineRepository;

  public List<Routine> getAllRoutine() {
    return routineRepository.findAll();
  }

  public Routine getRoutineById(Integer id) throws EntityNotFoundException {
    Optional<Routine> result = routineRepository.findById(id);
    if (result.isEmpty()) {
      throw new EntityNotFoundException("Routine (" + id + ") not found");
    }
    return result.get();
  }
}
