package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.sql.Time;
import java.time.Instant;

@Builder
@Data
@Value
public class ExerciseDto {
    Integer id;
    String name;
    String note;
    Time duration;
    Integer reps;
}
