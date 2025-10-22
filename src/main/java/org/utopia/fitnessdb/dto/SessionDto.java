package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;
import java.sql.Date;
import java.sql.Time;

@Builder
@Data
@Value
public class SessionDto {
    Integer id;
    Integer client;
    Integer trainer;
    Integer routine;
    Date date;
    String note;
    Time duration;
}
