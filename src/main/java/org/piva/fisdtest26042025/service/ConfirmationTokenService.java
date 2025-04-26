package org.piva.fisdtest26042025.service;

import lombok.RequiredArgsConstructor;
import org.piva.fisdtest26042025.entity.ConfirmationToken;
import org.piva.fisdtest26042025.entity.User;
import org.piva.fisdtest26042025.repository.ConfirmationTokenRepository;
import org.piva.fisdtest26042025.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;
    private final UserRepository userRepository;

    public String createToken(User user) {
        ConfirmationToken token = new ConfirmationToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUser(user);
        confirmationTokenRepository.save(token);
        return token.getToken();
    }

    public void validateToken(String tokenStr) {
        ConfirmationToken token = confirmationTokenRepository
                .findByToken(tokenStr)
                .orElseThrow(() -> new IllegalStateException("Invalid token"));
        User user = token.getUser();
        user.setEnabled(true);
        userRepository.save(user);
    }
}
