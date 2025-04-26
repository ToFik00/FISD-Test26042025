package org.piva.fisdtest26042025.security;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.piva.fisdtest26042025.entity.User;
import org.piva.fisdtest26042025.mapper.UserMapper;
import org.piva.fisdtest26042025.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email %s not found", email)));
        return userMapper.toCustomUserDetails(user);
    }
}