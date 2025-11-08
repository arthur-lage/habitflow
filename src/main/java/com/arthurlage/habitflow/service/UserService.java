package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers () {
        return this.userRepository.findAll();
    }
}
