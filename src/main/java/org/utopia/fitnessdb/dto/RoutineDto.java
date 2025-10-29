package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class RoutineDto {
    Integer id;
    String name;
    String description;
}
