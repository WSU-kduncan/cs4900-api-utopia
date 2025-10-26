package org.utopia.fitnessdb.repository;

// add java.util.Optional we need it

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {

    // add findByName method (you can look at me or Carson's code)

    // add a findByRoutineId method (very similar to the findByName)
  
}

