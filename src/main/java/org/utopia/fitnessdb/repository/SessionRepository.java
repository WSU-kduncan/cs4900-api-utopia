package org.utopia.fitnessdb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.utopia.fitnessdb.model.Session;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Integer> {
    // search by note string
    List<Session> findByNoteContainingIgnoreCase(String note);

}
