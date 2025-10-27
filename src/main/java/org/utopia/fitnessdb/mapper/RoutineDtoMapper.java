package org.utopia.fitnessdb.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.RoutineDto;
import org.utopia.fitnessdb.model.Routine;
import org.utopia.fitnessdb.service.RoutineService;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {RoutineService.class}
)

public interface RoutineDtoMapper {
    Routine toEntity(RoutineDto dto) throws EntityNotFoundException;

    RoutineDto toDto(Routine Routine) throws EntityNotFoundException;

    List<RoutineDto> toDtoList(List<Routine> Routines) throws EntityNotFoundException;
}

