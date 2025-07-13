package com.chetna.expensetracker.expense_tracker_api.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
}
