package com.project_be.service;

import com.project_be.model.Users;

import java.util.Optional;

public interface UserService {
    Optional<Users> findByUsername(String name);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Users save(Users users);
}
