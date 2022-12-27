package com.project_be.security.userprincal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project_be.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
public class UserPrinciple implements UserDetails {
    private Long id;
    private String name;
    private String email;
    private String username;
    @JsonIgnore
    private String password;
    private String avatar;
    private String address;
    private String phone;
    private Collection<? extends GrantedAuthority> roles;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public UserPrinciple(Long id, String name, String email, String username, String password, String avatar, String address, String phone, Collection<? extends GrantedAuthority> roles) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.address = address;
        this.phone = phone;
        this.roles = roles;
    }

    public UserPrinciple() {
    }

    public static UserPrinciple build(Users users){
        List<GrantedAuthority> authorities = users.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new UserPrinciple(users.getId(), users.getName(), users.getEmail(),users.getEmail() ,users.getPassword(), users.getAvatar(),users.getAddress(), users.getPhone(), authorities);
    }
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
