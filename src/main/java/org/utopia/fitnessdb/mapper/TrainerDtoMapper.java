package org.utopia.fitnessdb.mapper;

import jakarta.persistence.EntityNotFoundException;

import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.service.TrainerService;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {TrainerService.class})
public interface TrainerDtoMapper {
    Trainer toEntity(TrainerDto dto) throws EntityNotFoundException;

    TrainerDto toDto(Trainer trainer) throws EntityNotFoundException;

    List<TrainerDto> toDtoList(List<Trainer> trainers) throws EntityNotFoundException;
}
