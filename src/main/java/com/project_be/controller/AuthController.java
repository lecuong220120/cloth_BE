package com.project_be.controller;

import com.project_be.dto.request.SignInDTO;
import com.project_be.dto.request.SignUpDTO;
import com.project_be.dto.response.JwtResponseDTO;
import com.project_be.model.Role;
import com.project_be.model.RoleName;
import com.project_be.model.Users;
import com.project_be.repository.UserRepository;
import com.project_be.security.jwt.JwtProvider;
import com.project_be.security.userprincal.UserPrinciple;
import com.project_be.service.RoleService;
import com.project_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleService roleService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtProvider jwtProvider;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody SignUpDTO signUpDTO){
        if(userService.existsByUsername(signUpDTO.getUsername())){
            return new ResponseEntity<>("User exists!!", HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(signUpDTO.getEmail())){
            return new ResponseEntity<>("Email exists!!", HttpStatus.BAD_REQUEST);
        }
        Users users = new Users(signUpDTO.getName(), signUpDTO.getUsername(), passwordEncoder.encode(signUpDTO.getPassword()),signUpDTO.getEmail());
        Set<Role> roles = new HashSet<>();
        signUpDTO.getRoles().stream().forEach(role -> {
            switch (role){
                case "admin":
                    System.out.println(RoleName.ADMIN.name());
                    Role adminRole = roleService.findByRoleName(RoleName.ADMIN).orElseThrow(() -> new RuntimeException("ERROR ADMIN"));
                    roles.add(adminRole);
                    break;
                case "user":
                    Role userRole = roleService.findByRoleName(RoleName.USER).orElseThrow(() -> new RuntimeException("ERROR USER"));
                    roles.add(userRole);
                    break;
                case "customer":
                    Role customerRole = roleService.findByRoleName(RoleName.CUSTOMER).orElseThrow(() -> new RuntimeException("ERROR CUSTOMER"));
                    roles.add(customerRole);
                    break;
                default:
                    Role managerRole = roleService.findByRoleName(RoleName.MANAGER).orElseThrow(() -> new RuntimeException("ERROR CUSTOMER"));
                    roles.add(managerRole);
                    break;
            }
        });
        users.setRoles(roles);
        userService.save(users);
        return new ResponseEntity<>("Create user successful", HttpStatus.OK);
    }
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInDTO signInDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInDTO.getUsername(), signInDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return new ResponseEntity<>(new JwtResponseDTO(token, userPrinciple.getUsername(), userPrinciple.getAuthorities()), HttpStatus.OK);
    }
}
