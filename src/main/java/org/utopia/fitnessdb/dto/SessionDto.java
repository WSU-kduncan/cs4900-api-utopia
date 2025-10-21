package org.utopia.fitnessdb.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class SessionDto {
    Integer sessionId;
    Integer clientId;
    Integer trainerId;
    Integer routineId;
    Instant sessionDate;
    String note;
    Instant duration;
}
