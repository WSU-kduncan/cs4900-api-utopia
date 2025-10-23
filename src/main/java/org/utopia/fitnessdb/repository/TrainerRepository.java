package org.utopia.fitnessdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Trainer;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    Optional<Trainer> findByName(String name);

    Optional<Trainer> findByEmail(String email);
}