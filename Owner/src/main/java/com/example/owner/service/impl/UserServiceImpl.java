package com.example.owner.service.impl;

import com.example.owner.dto.UserDto;
import com.example.owner.entity.User;
import com.example.owner.exception.UniqueLoginException;
import com.example.owner.repository.RoleRepository;
import com.example.owner.repository.UserRepository;
import com.example.owner.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void addUser(UserDto userDto) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (userRepository.findUserByLogin(userDto.getLogin()).isPresent())
            throw new UniqueLoginException("Логин занят.");
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(roleRepository.getRolesById(2));

        userRepository.save(user);

    }
}
