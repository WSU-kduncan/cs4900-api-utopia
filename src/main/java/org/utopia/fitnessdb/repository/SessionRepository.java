package org.utopia.fitnessdb.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {
    List<Session> findByDate(Date date);
    
    List<Session> findByTrainerId(Integer trainer);
    
    List<Session> findByClientId(Integer client);
}
