package com.project_be.service.impl;

import com.project_be.model.Role;
import com.project_be.model.RoleName;
import com.project_be.repository.RoleRepository;
import com.project_be.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Optional<Role> findByRoleName(RoleName name) {
        return roleRepository.findByRoleName(name);
    }
}
