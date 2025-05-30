package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.JwtResponseDTO;
import com.example.ordermanagement.dto.UserLoginDTO;
import com.example.ordermanagement.dto.UserRegisterDTO;
import com.example.ordermanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Реєстрація та логін користувача")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Реєстрація користувача")
    public ResponseEntity<JwtResponseDTO> register(@RequestBody UserRegisterDTO dto) {
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping("/login")
    @Operation(summary = "Логін користувача")
    public ResponseEntity<JwtResponseDTO> login(@RequestBody UserLoginDTO dto) {
        return ResponseEntity.ok(userService.login(dto));
    }
}
