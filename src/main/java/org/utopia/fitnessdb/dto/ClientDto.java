package org.utopia.fitnessdb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class ClientDto {
    Integer clientId;
    String clientName;
    String clientEmail;
    String passwordHash;
    TrainerDto trainer;
}
