package org.utopia.fitnessdb.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.SessionDto;
import org.utopia.fitnessdb.model.Session;
import org.utopia.fitnessdb.service.SessionService;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {SessionService.class}
)
public interface SessionDtoMapper {
    Session toEntity(SessionDto dto) throws EntityNotFoundException;
    SessionDto toDto(Session session) throws EntityNotFoundException;
    List<SessionDto> toDtoList(List<Session> sessions) throws EntityNotFoundException;
}
