package org.utopia.fitnessdb.repository;

import org.utopia.fitnessdb.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    List<Trainer> findByNameContainingIgnoreCase(String name);
}
