package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.model.Client;
import org.utopia.fitnessdb.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id) throws EntityNotFoundException {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client with ID: " + id + " not found");
        }
        return client.get();
    }

    public Client getClientByEmail(String email) throws EntityNotFoundException {
        Optional<Client> client = clientRepository.findByEmail(email);
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client with email: " + email + " not found");
        }
        return client.get();
    }
}
