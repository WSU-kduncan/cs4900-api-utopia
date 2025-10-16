package org.utopia.fitnessdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Client")
public class Client {

    @Id
    @Column(name = "Client_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Client_id;

    @Column(name = "client_name", length = 50, nullable = false)
    String client_name;

    @Column(name = "client_email", length = 50, nullable = false)
    String client_email;

    @Column(name = "password_hash", length = 255, nullable = false)
    String password_hash;

    @ManytoOne
    @JoinColumn(name = "trainer_id", nullable = false)
    Trainer trainer;

    public Client(Integer Client_id) {
        this.Client_id = Client_id;
    }
}
