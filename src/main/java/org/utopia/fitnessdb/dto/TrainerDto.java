package org.utopia.fitnessdb.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class TrainerDto {
    Integer trainerId;
    String trainerName;
    String trainerEmail;
    String passwordHash;
}
