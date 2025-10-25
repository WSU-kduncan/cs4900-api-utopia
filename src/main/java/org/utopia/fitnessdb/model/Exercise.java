package org.utopia.fitnessdb.model;

import java.time.Duration;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Exercise")
public class Exercise {

    @Id
    @Column(name = "exercise_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "exercise_name", length = 50, nullable = false, unique = true)
    private String name;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "duration", nullable = true)
    private Duration duration;

    @Column(name = "reps", nullable = true)
    private Integer reps;
}
