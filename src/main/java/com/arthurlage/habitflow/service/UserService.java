package com.arthurlage.habitflow.service;

import com.arthurlage.habitflow.dto.CreateUserRequestDTO;
import com.arthurlage.habitflow.dto.LoginRequestDTO;
import com.arthurlage.habitflow.exception.InvalidCredentialsException;
import com.arthurlage.habitflow.exception.UsernameOrEmailTakenException;
import com.arthurlage.habitflow.model.User;
import com.arthurlage.habitflow.repository.UserRepository;
import com.arthurlage.habitflow.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers () {
        return this.userRepository.findAll();
    }

    public String createUser(CreateUserRequestDTO data) {
        if(this.userRepository.existsByUsername(data.username())) {
            throw new UsernameOrEmailTakenException("This username is already being used.");
        }

        if(this.userRepository.existsByEmail(data.email())) {
            throw new UsernameOrEmailTakenException("This email is already being used.");
        }

        String hashedPass = this.passwordEncoder.encode(data.password());
        User user = new User(data, hashedPass);

        this.userRepository.save(user);

        return this.jwtService.generateToken(user.getEmail());
    }

    public String login (LoginRequestDTO loginRequestDTO) {
        User user = this.userRepository.findByEmail(loginRequestDTO.email()).orElseThrow(() -> new InvalidCredentialsException("Incorrect email or password."));

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        boolean passwordsMatch = bcrypt.matches(loginRequestDTO.password(), user.getPassword());

        if(!passwordsMatch) {
            throw new InvalidCredentialsException("Incorrect email or password.");
        }

        return this.jwtService.generateToken(user.getEmail());
    }
}
