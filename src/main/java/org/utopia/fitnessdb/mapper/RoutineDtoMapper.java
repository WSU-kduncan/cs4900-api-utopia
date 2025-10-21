
package org.utopia.fitnessdb.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utopia.fitnessdb.controller.RoutineController;
import org.utopia.fitnessdb.dto.RoutineDto;
import org.utopia.fitnessdb.mapper.RoutineDtoMapper;
import org.utopia.fitnessdb.repository.RoutineRepository;
import org.utopia.fitnessdb.service.RoutineService;
import org.utopia.fitnessdb.model.Routine;

import java.util.List;

@Mapper(
    componentModel = "spring",
    uses = {Routineservice.class})
public interface RoutineDtoMapper {

  Routine toEntity(RoutineDto routineDto) throws EntityNotFoundException;

  RoutineDto toDto(Routine routine) throws EntityNotFoundException;

  List<RoutineDto> toDtoList(List<Routine> routineList) throws EntityNotFoundException;
}
