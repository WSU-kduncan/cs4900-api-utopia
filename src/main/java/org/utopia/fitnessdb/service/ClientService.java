package org.utopia.fitnessdb.service;

import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.utopia.fitnessdb.dto.ClientDto;
import org.utopia.fitnessdb.mapper.ClientDtoMapper;
import org.utopia.fitnessdb.mapper.TrainerDtoMapper;
import org.utopia.fitnessdb.model.Client;
import org.utopia.fitnessdb.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repository;
    private final ClientDtoMapper mapper;
    private final TrainerDtoMapper trainerMapper;

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Client getClientById(Integer id) throws EntityNotFoundException {
        Optional<Client> client = repository.findById(id);
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client with ID " + id + " not found");
        }
        return client.get();
    }

    public Client getClientByEmail(String email) throws EntityNotFoundException {
        Optional<Client> client = repository.findByEmail(email);
        if (client.isEmpty()) {
            throw new EntityNotFoundException("Client with email " + email + " not found");
        }
        return client.get();
    }

    public Client createClient(ClientDto clientDto) throws EntityNotFoundException {
        return repository.saveAndFlush(mapper.toEntity(clientDto));
    }

    public Client updateClient(Integer id, ClientDto clientDto) throws EntityNotFoundException {
        Client client = repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("Client with ID " + id + " not found"));

        if (clientDto.getEmail() != null) client.setEmail(clientDto.getEmail());
        if (clientDto.getName() != null) client.setName(clientDto.getName());
        if (clientDto.getTrainer() != null)
            client.setTrainer(trainerMapper.toEntity(clientDto.getTrainer()));
        if (clientDto.getPasswordHash() != null)
            client.setPasswordHash(clientDto.getPasswordHash());

        return repository.saveAndFlush(client);
    }
}
