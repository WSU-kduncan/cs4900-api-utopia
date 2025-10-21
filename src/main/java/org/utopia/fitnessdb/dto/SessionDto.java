package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import org.utopia.fitnessdb.model.Routine;

import java.sql.Date;
import java.sql.Time;
import java.time.Instant;
import java.util.List;

@Builder
@Data
@Value
public class SessionDto {
    Integer id;
    ClientDto client;
    TrainerDto trainer;
    RoutineDto routine;
    Date date;
    String note;
    Time duration;
}
