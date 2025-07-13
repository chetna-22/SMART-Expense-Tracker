package com.chetna.expensetracker.expense_tracker_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chetna.expensetracker.expense_tracker_api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
