
package org.utopia.fitnessdb.dto;

import java.time.Instant;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class Exercisedto {

  Integer exerciseId;

  String exerciseName;

  String note;

  Instant duration;

  Integer reps;
}
