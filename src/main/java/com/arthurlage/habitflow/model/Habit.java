package com.arthurlage.habitflow.model;

import com.arthurlage.habitflow.dto.CreateHabitRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.Set;

@Data
@Entity
public class Habit {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // SUGGESTIONS:
    // Goal tracking characteristics: measure unit (eg: pages, liters, meters), quantity (2 liters, 10 pages)
    // Streak: Every time you accomplish your habit in the desired days, you maintain a streak

    private String name;
    private String description;

    @ElementCollection(targetClass = DayOfWeek.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "habit_days",
            joinColumns = @JoinColumn(name = "habit_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<DayOfWeek> weeklyFrequency = EnumSet.noneOf(DayOfWeek.class);

    private String category;
    private String motivation;

    @Enumerated(EnumType.STRING)
    private HabitStatus status = HabitStatus.ACTIVE;

    public Habit(CreateHabitRequestDTO createHabitRequestDTO, User user) {
        this.name = createHabitRequestDTO.name();
        if (createHabitRequestDTO.description() != null && !createHabitRequestDTO.description().isBlank()) this.description = createHabitRequestDTO.description();
        if (createHabitRequestDTO.category() != null && !createHabitRequestDTO.category().isBlank()) this.category = createHabitRequestDTO.category();
        if (createHabitRequestDTO.motivation() != null && !createHabitRequestDTO.motivation().isBlank()) this.motivation = createHabitRequestDTO.motivation();
        this.weeklyFrequency = createHabitRequestDTO.weekdays();
        this.user = user;
    }
}
