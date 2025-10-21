package org.utopia.fitnessdb.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.dto.ClientDto;
import org.utopia.fitnessdb.mapper.ClientDtoMapper;
import org.utopia.fitnessdb.service.ClientService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(
        path = "client",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {
    private final ClientDtoMapper m_mapper;
    private final ClientService m_service;

    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(m_mapper.toDtoList(m_service.getAllClients()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(m_mapper.toDto(m_service.getClientById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<ClientDto> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                m_mapper.toDto(m_service.getClientByEmail(email)), HttpStatus.OK);
    }
}
