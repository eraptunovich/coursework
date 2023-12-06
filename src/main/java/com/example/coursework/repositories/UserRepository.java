package com.example.coursework.repositories;

import com.example.coursework.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByLogin(String login);

    @Override
    Optional<User> findById(Long id);
}
