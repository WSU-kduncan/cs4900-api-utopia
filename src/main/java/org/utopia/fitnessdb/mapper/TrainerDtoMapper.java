package org.utopia.fitnessdb.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.utopia.fitnessdb.dto.TrainerDto;
import org.utopia.fitnessdb.model.Trainer;
import org.utopia.fitnessdb.service.TrainerService;

import jakarta.persistence.EntityNotFoundException;

@Mapper(
        componentModel = "spring",
        uses = {TrainerService.class})
public interface TrainerDtoMapper {
    Trainer toEntity(TrainerDto dto) throws EntityNotFoundException;

    TrainerDto toDto(Trainer trainer) throws EntityNotFoundException;

    List<TrainerDto> toDtoList(List<Trainer> trainers) throws EntityNotFoundException;

    @InheritConfiguration
    Trainer updateEntity(TrainerDto trainerDto, @MappingTarget Trainer trainer) throws EntityNotFoundException;
}
