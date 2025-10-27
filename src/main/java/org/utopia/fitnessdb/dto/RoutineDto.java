package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class RoutineDto {

<<<<<<< HEAD
    Integer routineId;

    String routineName;
=======
  // reanme routineId to id 
  Integer id;

  // rename routineName to name 
  String name;
>>>>>>> 0a354767b73d047550c6a29f4f4694475de97e2c

    String description;
}
