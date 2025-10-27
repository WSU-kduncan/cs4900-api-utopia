package org.utopia.fitnessdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Trainer")
@Getter
@Setter
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_id", nullable = false)
    private Integer trainerId;

    @Column(name = "trainer_name", nullable = false, length = 50)
    private String trainerName;

    @Column(name = "trainer_email", nullable = false, unique = true, length = 50)
    private String trainerEmail;

    @Column(name = "password_hash", nullable = false, length = 255)
    private String passwordHash;
}
