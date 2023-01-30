package com.example.owner.security.service;

import com.example.owner.repository.UserRepository;
import com.example.owner.security.model.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findUserByLogin(username)
                .map(SecurityUser::new)
                .orElseThrow(()-> new UsernameNotFoundException(
                        "User with login = '%s' not found".formatted(username)
                ));
    }
}
