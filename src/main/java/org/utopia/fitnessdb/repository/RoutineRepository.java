package org.utopia.fitnessdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Routine;

import java.util.Optional;

@Repository
public interface RoutineRepository  extends JpaRepository<Routine, Integer> {
    Optional<Routine> findByName(String name); 

}
