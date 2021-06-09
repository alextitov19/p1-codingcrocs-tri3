package com.codingcorcs.demo.security.Perms;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public enum Roles {
    Admin,
    User;
    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        return new HashSet<>(List.of(new SimpleGrantedAuthority("ROLE_" + this.name())));
    }
}
