package org.utopia.fitnessdb.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;

@Entity
@Table(name = "Session")
@Getter
@Setter
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "session_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine;

    @Column(name = "session_date", nullable = false)
    private Date date;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "duration")
    private Time duration;
}