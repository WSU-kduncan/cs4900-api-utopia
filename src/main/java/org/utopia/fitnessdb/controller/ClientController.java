package org.utopia.fitnessdb.controller;

import jakarta.persistence.EntityNotFoundException;

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
import org.utopia.fitnessdb.object.LoginForm;
import org.utopia.fitnessdb.service.ClientService;

import java.util.List;

import javax.security.auth.login.FailedLoginException;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "client",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientDtoMapper clientMapper;
    private final ClientService clientService;

    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(clientMapper.toDtoList(clientService.getAllClients()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(clientMapper.toDto(clientService.getClientById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<ClientDto> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                clientMapper.toDto(clientService.getClientByEmail(email)), HttpStatus.OK);
    }

    @PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> login(@RequestBody LoginForm form) {
        Client client;
        try {
            client = clientService.login(form.getEmail(), form.getPasswordHash());
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        } catch (FailedLoginException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(clientMapper.toDto(client), HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> createClient(@RequestBody ClientDto clientDto) {
        Client client;
        try {
            client = clientService.createClient(clientDto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PutMapping(path = "{id}")
    ResponseEntity<Object> updateClient(
            @PathVariable("id") Integer id, @RequestBody ClientDto clientDto) {
        Client client;
        try {
            client = clientService.updateClient(id, clientDto);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(clientMapper.toDto(client), HttpStatus.OK);
    }
}
