package org.piva.fisdtest26042025.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.piva.fisdtest26042025.dto.auth.ConfirmationRequest;
import org.piva.fisdtest26042025.dto.auth.RegistrationRequest;
import org.piva.fisdtest26042025.service.ConfirmationTokenService;
import org.piva.fisdtest26042025.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api/auth")
@Validated
public class AuthController {
    private final UserService userService;
    private final ConfirmationTokenService confirmationTokenService;

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegistrationRequest request) {
        userService.registerUser(request.getEmail(), request.getPassword());
        return "Регистрация успешна. Проверьте почту для кода подтверждения.";
    }

    @PostMapping("/confirm")
    public String confirm(@RequestBody @Valid ConfirmationRequest request) {
        confirmationTokenService.validateToken(request.getToken());
        return "Аккаунт успешно активирован.";
    }
}
