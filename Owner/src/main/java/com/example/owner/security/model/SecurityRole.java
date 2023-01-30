package com.example.owner.security.model;

import com.example.owner.entity.Role;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@ToString
@RequiredArgsConstructor
public class SecurityRole implements GrantedAuthority {
    private final Role role;

    @Override
    public String getAuthority() {
        return role.getRole().toUpperCase();
    }
}
