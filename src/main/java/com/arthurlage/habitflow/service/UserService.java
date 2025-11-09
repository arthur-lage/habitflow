package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.dto.CreateUserRequestDTO;
import com.arthurlage.habitflow.exception.UsernameOrEmailTakenException;
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

    public void createUser(CreateUserRequestDTO data) {

        if(this.userRepository.existsByUsername(data.username())) {
            throw new UsernameOrEmailTakenException("This username is already being used.");
        }

        if(this.userRepository.existsByEmail(data.email())) {
            throw new UsernameOrEmailTakenException("This email is already being used.");
        }

        User user = new User(data);

        this.userRepository.save(user);
    }
}
