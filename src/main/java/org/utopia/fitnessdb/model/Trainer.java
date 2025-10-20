package org.utopia.fitnessdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @Column(name = "trainer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name", length = 50, nullable = false)
    String name; 

    @Column(name = "email", length = 50, nullable = false)
    String emailAddress; 

    @Column(name = "password_hash", length = 255, nullable = false)
    String passwordHash; 

}
