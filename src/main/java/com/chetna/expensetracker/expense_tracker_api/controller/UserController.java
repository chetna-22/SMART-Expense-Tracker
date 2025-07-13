package com.chetna.expensetracker.expense_tracker_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetna.expensetracker.expense_tracker_api.dto.LoginDTO;
import com.chetna.expensetracker.expense_tracker_api.dto.UserDTO;
import com.chetna.expensetracker.expense_tracker_api.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.login(loginDTO);
    }
}
