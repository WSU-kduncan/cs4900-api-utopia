package org.utopia.fitnessdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Routine;

@Repository
public interface RoutineRepository extends JpaRepository<Routine, Integer> {

    Optional<Routine> findByName(String name);

    Optional<Routine> findById(Integer id);

}
