package org.utopia.fitnessdb.object;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
@Value
public class LoginForm {
    private String email;
    private String passwordHash;
}
