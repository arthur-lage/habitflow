package com.arthurlage.habitflow.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateUserRequestDTO(
        @NotBlank(message = "Name is mandatory.") String name,
        @NotBlank(message = "Username is mandatory.") String username,
        @NotBlank(message = "Email is mandatory.") String email,
        @NotBlank(message = "Password is mandatory.") String password){};
