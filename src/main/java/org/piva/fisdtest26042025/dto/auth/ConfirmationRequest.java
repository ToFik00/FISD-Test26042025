package org.piva.fisdtest26042025.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfirmationRequest {

    @NotBlank
    private String token;
}
