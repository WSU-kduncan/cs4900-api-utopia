package org.utopia.fitnessdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @Column(name = "session_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer exerciseId;

    @JoinColumn(name = "client)id", nullable = false)
    String clientId; 

    @JoinColumn(name = "trainer_id", nullable = false)
    String trainerId; 

    @JoinColumn(name = "routine_id", nullable = false)
    String routineId; 

    @Column(name = "name", length = 50, nullable = false)
    String sessionName; 

    @Column(name = "note", nullable = true)
    String notes; 

    @Column(name = "duration", nullable = true)
    String duration; 

}
