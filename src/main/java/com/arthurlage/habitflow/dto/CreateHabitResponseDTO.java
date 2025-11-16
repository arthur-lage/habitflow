package com.arthurlage.habitflow.dto;

import com.arthurlage.habitflow.model.Habit;

public record CreateHabitResponseDTO(
        Habit habit,
        String message
) {
}
