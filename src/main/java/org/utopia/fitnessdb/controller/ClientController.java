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

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "client",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientDtoMapper clientMapper;
    private final ClientService clientService;

    @GetMapping
    ResponseEntity<List<ClientDto>> getAllClients() {
        return new ResponseEntity<>(
                clientMapper.toDtoList(clientService.getAllClients()), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    ResponseEntity<ClientDto> getClientById(@PathVariable Integer id) {
        return new ResponseEntity<>(
                clientMapper.toDto(clientService.getClientById(id)), HttpStatus.OK);
    }

    @GetMapping(path = "email/{email}")
    ResponseEntity<ClientDto> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(
                clientMapper.toDto(clientService.getClientByEmail(email)), HttpStatus.OK);
    }
}
