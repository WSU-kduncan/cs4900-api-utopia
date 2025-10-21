package org.utopia.fitnessdb.repository;

import org.utopia.fitnessdb.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {
  
}

