package org.utopia.fitnessdb.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.controller.ExerciseController;
import org.utopia.fitnessdb.dto.ExerciseDto;
import org.utopia.fitnessdb.mapper.ExerciseDtoMapper;
import org.utopia.fitnessdb.repository.ExerciseRepository;
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
