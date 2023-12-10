package com.example.coursework.repositories;

import com.example.coursework.models.IssueCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<IssueCategories, Long> {

}
