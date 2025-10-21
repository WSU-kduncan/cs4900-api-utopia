package org.utopia.fitnessdb.mapper;

import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;
import org.utopia.fitnessdb.dto.ExerciseDto;
import org.utopia.fitnessdb.model.Exercise;
import org.utopia.fitnessdb.service.ExerciseService;

import java.util.List;

@Mapper(
        componentModel = "spring",
        uses = {ExerciseService.class}
)
public interface ExerciseDtoMapper {
    Exercise toEntity(ExerciseDto dto) throws EntityNotFoundException;
    ExerciseDto toDto(Exercise exercise) throws EntityNotFoundException;
    List<ExerciseDto> toDtoList(List<Exercise> exercises) throws EntityNotFoundException;
}
