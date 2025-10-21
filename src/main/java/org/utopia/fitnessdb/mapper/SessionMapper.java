package org.utopia.fitnessdb.mapper;

import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.SessionDto;
import org.utopia.fitnessdb.model.Session;


import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {

    // Map Session → SessionDto
    SessionDto toDto(Session session);

    // Map SessionDto → Session
    Session toEntity(SessionDto dto);

    // Map list of Sessions → list of SessionDto
    List<SessionDto> toDtoList(List<Session> sessions);
}

