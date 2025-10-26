
package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class RoutineDto {

  // reanme routineId to id 
  Integer routineId;

  // rename routineName to name 
  String routineName;

  String description;
}
