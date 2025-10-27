package org.utopia.fitnessdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {}
