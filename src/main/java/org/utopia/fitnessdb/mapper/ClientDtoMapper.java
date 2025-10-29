package org.utopia.fitnessdb.mapper;

import jakarta.persistence.EntityNotFoundException;

import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.ClientDto;
import org.utopia.fitnessdb.model.Client;
import org.utopia.fitnessdb.service.ClientService;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {ClientService.class})
public interface ClientDtoMapper {
    Client toEntity(ClientDto dto) throws EntityNotFoundException;

    ClientDto toDto(Client client) throws EntityNotFoundException;

    List<ClientDto> toDtoList(List<Client> clients) throws EntityNotFoundException;

    //    @InheritConfiguration
    //    Client updateEntity(ClientDto clientDto, @MappingTarget Client client) throws
    // EntityNotFoundException;
}
