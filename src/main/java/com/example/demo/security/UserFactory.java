package com.example.demo.security;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class UserFactory {
    public static UserDetails create(User user) {
        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getLogin(),
                user.getPassword(),
                user.getRole(),
                mapToGrantedAuthorities(user.getRole())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role userRole) {
        List<GrantedAuthority> userRoles = new ArrayList<>();
        userRoles.add(new SimpleGrantedAuthority(userRole.name()));
        return userRoles;
    }

}
