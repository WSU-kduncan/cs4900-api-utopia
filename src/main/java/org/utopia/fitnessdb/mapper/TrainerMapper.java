package org.utopia.fitnessdb.mapper;

import org.utopia.fitnessdb.dto.TrainerDTO;
import org.utopia.fitnessdb.model.Trainer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainerMapper {
    public TrainerDTO toDTO(Trainer trainer) {
        if (trainer == null) {
            return null;
        }

        return new TrainerDTO(
                trainer.getTrainerId(),
                trainer.getName(),
                trainer.getEmail(),
                trainer.getSpecialty()
        );
    }

    public List<TrainerDTO> toDTOList(List<Trainer> trainers) {
        return trainers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
