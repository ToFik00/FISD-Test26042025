package org.piva.fisdtest26042025.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistrationRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
