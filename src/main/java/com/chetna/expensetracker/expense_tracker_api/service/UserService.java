package com.chetna.expensetracker.expense_tracker_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chetna.expensetracker.expense_tracker_api.dto.LoginDTO;
import com.chetna.expensetracker.expense_tracker_api.dto.UserDTO;
import com.chetna.expensetracker.expense_tracker_api.model.User;
import com.chetna.expensetracker.expense_tracker_api.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String register(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "Email already in use.";
        }

        User user = User.builder()
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword()) // 🔒 Later, hash this!
                .build();

        userRepository.save(user);
        return "User registered successfully!";
    }

    public String login(LoginDTO loginDTO) {
        Optional<User> user = userRepository.findByEmail(loginDTO.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(loginDTO.getPassword())) {
            return "Login successful!";
        }
        return "Invalid email or password.";
    }
}
