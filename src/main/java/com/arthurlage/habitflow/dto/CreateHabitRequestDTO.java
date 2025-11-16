package com.arthurlage.habitflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.DayOfWeek;
import java.util.Set;

public record CreateHabitRequestDTO(@NotBlank(message = "Habit name is mandatory.") String name, String description, String category, String motivation, @NotEmpty(message = "You need to choose at least one day.") Set<DayOfWeek> weekdays) {
}
