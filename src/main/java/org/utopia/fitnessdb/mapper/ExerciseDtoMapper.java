package org.utopia.fitnessdb.mapper;
import jakarta.persistence.EntityNotFoundException;
import org.mapstruct.Mapper;

import org.utopia.fitnessdb.dto.ExerciseDto;
import org.utopia.fitnessdb.service.ExerciseService;
import org.utopia.fitnessdb.model.Exercise;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {ExerciseService.class})
public interface ExerciseDtoMapper {

  Exercise toEntity(ExerciseDto ExerciseDto) throws EntityNotFoundException;

  ExerciseDto toDto(Exercise exercise) throws EntityNotFoundException;

  List<ExerciseDto> toDtoList(List<Exercise> exerciseList) throws EntityNotFoundException;
}
