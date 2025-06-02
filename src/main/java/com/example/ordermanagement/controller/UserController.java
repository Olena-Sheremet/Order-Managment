package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.*;
import com.example.ordermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDTO> register(@RequestBody UserRegisterDTO dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserLoginDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}