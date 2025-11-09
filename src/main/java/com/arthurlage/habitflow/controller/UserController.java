package com.arthurlage.habitflow.controller;

import com.arthurlage.habitflow.dto.CreateUserRequestDTO;
import com.arthurlage.habitflow.dto.CreateUserResponseDTO;
import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDTO> createUser (@RequestBody CreateUserRequestDTO data) {
        this.userService.createUser(data);
        CreateUserResponseDTO body = new CreateUserResponseDTO("User created successfully");
        return ResponseEntity.ok(body);
    }
}
