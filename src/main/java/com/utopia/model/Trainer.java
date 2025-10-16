package com.utopia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Trainer")
public class Trainer {

    @Id
    @Column(name = "trainer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "trainer_name", length = 50, nullable = false)
    String name;

    @Column(name = "trainer_email", length = 50, nullable = false, unique = true)
    String email;

    @Column(name = "password_hash", length = 255, nullable = false)
    String passwordHash;
}
