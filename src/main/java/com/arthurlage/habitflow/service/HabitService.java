package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.model.Habit;
import com.arthurlage.habitflow.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {
    private final HabitRepository habitRepository;

    public HabitService(HabitRepository habitRepository) {
        this.habitRepository = habitRepository;
    }

    public List<Habit> getHabits () {
        return this.habitRepository.findAll();
    }
}
