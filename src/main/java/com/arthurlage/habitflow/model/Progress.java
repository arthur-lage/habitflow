package com.arthurlage.habitflow.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Progress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn(name = "habit_id")
    private Habit habit;

    private LocalDate date;
    private boolean completed;

}