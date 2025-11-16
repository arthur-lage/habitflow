package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.dto.CreateHabitRequestDTO;
import com.arthurlage.habitflow.model.Habit;
import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {
    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getHabits (User user) {
        return this.habitRepository.findByUserId(user.getId());
    }

    public Habit createHabit(CreateHabitRequestDTO createHabitRequestDTO, User user) {
        Habit habit = new Habit(createHabitRequestDTO, user);
        return this.habitRepository.save(habit);
    }
}
