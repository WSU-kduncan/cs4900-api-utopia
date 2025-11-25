package org.utopia.fitnessdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDto {
    Integer id;
    String name;
    String email;
    String passwordHash;
}
