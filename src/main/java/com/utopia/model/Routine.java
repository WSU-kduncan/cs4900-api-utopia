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
@Table(name = "Routine")
public class Routine {

    @Id
    @Column(name = "routine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "routine_name", length = 50, nullable = false, unique = true)
    String name;

    @Column(name = "description", length = 255, nullable = false)
    String description;
}
