package org.utopia.fitnessdb.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

import java.sql.Time;
import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Exercise")
@Getter
@Setter
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id", nullable = false)
    private Integer id;

    @Column(name = "exercise_name", nullable = false, unique = true, length = 50)
    private String name;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "reps")
    private Integer reps;
}