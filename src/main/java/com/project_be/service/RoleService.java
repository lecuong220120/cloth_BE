package com.project_be.service;

import com.project_be.model.Role;
import com.project_be.model.RoleName;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByRoleName(RoleName name);
}
