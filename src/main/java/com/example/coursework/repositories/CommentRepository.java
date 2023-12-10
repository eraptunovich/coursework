package com.example.coursework.repositories;

import com.example.coursework.models.IssueCategories;
import com.example.coursework.models.IssueComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<IssueComments, Long> {

}
