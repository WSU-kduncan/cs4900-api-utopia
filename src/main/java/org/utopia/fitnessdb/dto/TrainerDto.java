package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class TrainerDto {
    Integer id;
    String name;
    String email;
    String passwordHash;
}
