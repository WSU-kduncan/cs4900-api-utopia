package org.utopia.fitnessdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.model.Session;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    Optional<Session> findByDate(Date date);
    Optional<Session> findByTrainerId(Integer trainer);
    Optional<Session> findByClientId(Integer client);
}
