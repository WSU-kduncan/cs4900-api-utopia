package model; 

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
    Integer exerciseId;

    @Column(name = "name", length = 50, nullable = false)
    String exerciseName; 

    @Column(name = "note", nullable = true)
    String notes; 

    @Column(name = "duration", nullable = true)
    String duration; 

    @Column(name = "reps", nullable = false)
    String reps; 

}
