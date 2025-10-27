package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.sql.Time;

@Builder
@Data
@Value
public class ExerciseDto {

    Integer exerciseId;

    String exerciseName;

    String note;

    Time duration;

    Integer reps;
}
