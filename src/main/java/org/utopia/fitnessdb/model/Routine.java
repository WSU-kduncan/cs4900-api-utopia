package org.utopia.fitnessdb.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
//import java.util.List;

@Entity
@Table(name = "Routine")
@Getter
@Setter
public class Routine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "routine_id", nullable = false)
    private Integer routineId;

    @Column(name = "routine_name", nullable = false, unique = true, length = 50)
    private String routineName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}