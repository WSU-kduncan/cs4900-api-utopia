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
    // Map SessionDto → Session
    Session toEntity(SessionDto dto) throws EntityNotFoundException;
    
    // Map Session → SessionDto
    SessionDto toDto(Session session) throws EntityNotFoundException;

    // Map list of Sessions → list of SessionDto
    List<SessionDto> toDtoList(List<Session> sessions) throws EntityNotFoundException;
}