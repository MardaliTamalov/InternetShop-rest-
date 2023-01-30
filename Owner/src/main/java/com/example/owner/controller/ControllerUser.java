package com.example.owner.controller;

import com.example.owner.dto.UserDto;
import com.example.owner.service.UserService;
import com.example.owner.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor

public class ControllerUser {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return ResponseEntity.ok().build();
    }
}
