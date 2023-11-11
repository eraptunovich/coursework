package com.example.coursework.repositories;

import com.example.coursework.models.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {
    List<Issue> findByTitle(String title);
}
