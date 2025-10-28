package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.ClientDto;
import org.utopia.fitnessdb.mapper.ClientDtoMapper;
import org.utopia.fitnessdb.model.Client;
import org.utopia.fitnessdb.service.ClientService;

import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "client",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientDtoMapper mapper;
    private final ClientService service;

    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(mapper.toDtoList(service.getAllClients()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.toDto(service.getClientById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<ClientDto> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                mapper.toDto(service.getClientByEmail(email)), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createClient(@RequestBody ClientDto clientDto) {
        Client client;
        try {
            client = service.createClient(clientDto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    ResponseEntity<Object> updateClient(@PathVariable("id") Integer id, @RequestBody ClientDto clientDto) {
        Client client;
        try {
            client = service.updateClient(id, clientDto);
        } catch (EntityNotFoundException e) {
                  return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(mapper.toDto(client), HttpStatus.OK);
    }
}
