package org.utopia.fitnessdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.utopia.fitnessdb.model.Client;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> findByClientName(String name);
    Optional<Client> findByClientEmail(String email);
}
