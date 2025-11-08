package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.model.Progress;
import com.arthurlage.habitflow.repository.ProgressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressService {
    private final ProgressRepository progressRepository;

    public ProgressService(ProgressRepository progressRepository) {
        this.progressRepository = progressRepository;
    }

    public List<Progress> getProgress () {
        return this.progressRepository.findAll();
    }
}
