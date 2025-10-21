package org.utopia.fitnessdb.model;

import java.time.Duration;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Session")
public class Session {

    @Id
    @Column(name = "session_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "client_id", nullable = false)
    @ManyToOne
    private Client client;

    @JoinColumn(name = "trainer_id", nullable = false)
    @ManyToOne
    private Trainer trainer;

    @JoinColumn(name = "routine_id", nullable = false)
    @ManyToOne
    private Routine routine;

    @Column(name = "session_date", nullable = false)
    private LocalDateTime sessionDate;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "duration", nullable = true)
    private Duration duration;
}
