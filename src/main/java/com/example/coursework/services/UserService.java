package com.example.coursework.services;

import com.example.coursework.models.User;
import com.example.coursework.models.enums.Role;
import com.example.coursework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        System.out.println(user);
        String login = user.getLogin();
        if(userRepository.findByLogin(login)!=null) return false;
        user.setActive(true);

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new Programmer with login: {}", login);
        userRepository.save(user);
        return true;
    }
}
