package com.example.coursework.services;

import com.example.coursework.models.Issue;
import com.example.coursework.models.User;
import com.example.coursework.models.enums.Role;
import com.example.coursework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null); //если не нашли объект, то возвращаем null
    }

    public List<User> list() {
        return userRepository.findAll();
    }

    public void banUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.isActive()) {
                user.setActive(false);
                log.info("Ban user with id = {}; email: {}", user.getUserId(), user.getEmail());
            } else {
                user.setActive(true);
                log.info("Unban user with id = {}; email: {}", user.getUserId(), user.getEmail());
            }
        }
        userRepository.save(user);
    }

    public void changeUserRoles(User user, String role) {
        Set<Role> r = new HashSet<>();
        r.add(Role.valueOf(role));
        user.setRole(r);
        userRepository.save(user);
    }
}
