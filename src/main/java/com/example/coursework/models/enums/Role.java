package com.example.coursework.models.enums;

import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {
    TESTER,
    PROGRAMMER,
    ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }

    @Override
    public String toString() {
        return name();
    }

}
