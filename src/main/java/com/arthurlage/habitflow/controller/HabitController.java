package com.arthurlage.habitflow.controller;

import com.arthurlage.habitflow.dto.CreateHabitRequestDTO;
import com.arthurlage.habitflow.dto.CreateHabitResponseDTO;
import com.arthurlage.habitflow.model.Habit;
import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.security.CustomUserDetails;
import com.arthurlage.habitflow.service.HabitService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {
    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    @GetMapping
    public List<Habit> getHabits(@AuthenticationPrincipal User user) {
        return this.habitService.getHabits(user);
    }

    @PostMapping
    public ResponseEntity<CreateHabitResponseDTO> createHabit(@AuthenticationPrincipal CustomUserDetails userDetails, @RequestBody @Valid CreateHabitRequestDTO createHabitDTO) {
        User user = userDetails.getUser();
        Habit habit = this.habitService.createHabit(createHabitDTO, user);
        CreateHabitResponseDTO body = new CreateHabitResponseDTO(habit, "Habit was created successfully.");
        return ResponseEntity.ok(body);
    }
}
