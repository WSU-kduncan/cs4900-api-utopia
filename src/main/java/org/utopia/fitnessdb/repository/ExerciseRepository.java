package org.utopia.fitnessdb.repository;

import java.util.Optional;

import org.utopia.fitnessdb.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    Optional<Exercise> findByName(String name);

    Optional<Exercise> findById(Integer id);
}