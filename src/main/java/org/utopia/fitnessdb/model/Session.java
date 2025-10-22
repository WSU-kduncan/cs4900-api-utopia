package org.utopia.fitnessdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.Duration;
import java.time.LocalDateTime;

import org.hibernate.annotations.ManyToAny;

@Data
@Entity
@Table(name = "session")
public class Session {

    @Id
    @Column(name = "session_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_ls id", nullable = false)
    private Client client; 

    @ManyToOne
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer; 

    @ManyToOne
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine; 

    @Column(name = "session_date", nullable = false)
    private LocalDateTime sessionDate;

    @Column(name = "note", length = 255)
    private String note;

    @Column(name = "duration", nullable = true)
    private Duration duration;

}