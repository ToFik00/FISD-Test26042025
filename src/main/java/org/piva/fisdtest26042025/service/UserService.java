package org.piva.fisdtest26042025.service;

import lombok.RequiredArgsConstructor;
import org.piva.fisdtest26042025.entity.User;
import org.piva.fisdtest26042025.repository.UserRepository;
import org.piva.fisdtest26042025.util.EmailSenderUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final EmailSenderUtil emailSenderUtil;

    public void registerUser(String email, String password) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalStateException("Email already taken");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(false);
        userRepository.save(user);

        String token = confirmationTokenService.createToken(user);
        emailSenderUtil.sendEmail(email, "Email Confirmation", "Your confirmation code: " + token);
    }
}
