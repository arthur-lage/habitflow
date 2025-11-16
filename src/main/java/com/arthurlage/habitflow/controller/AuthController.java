package com.arthurlage.habitflow.controller;

import com.arthurlage.habitflow.dto.CreateUserRequestDTO;
import com.arthurlage.habitflow.dto.CreateUserResponseDTO;
import com.arthurlage.habitflow.dto.LoginRequestDTO;
import com.arthurlage.habitflow.dto.LoginResponseDTO;
import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/auth")
@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping
    public List<User> getUsers() {
        return this.authService.getUsers();
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser (@Valid @RequestBody CreateUserRequestDTO data) {
        String token = this.authService.createUser(data);
        CreateUserResponseDTO body = new CreateUserResponseDTO("User created successfully", token);
        return ResponseEntity.ok(body);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login (@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        String token = this.authService.login(loginRequestDTO);
        LoginResponseDTO body = new LoginResponseDTO("Login was successful.", token);
        return ResponseEntity.ok(body);
    }
}
