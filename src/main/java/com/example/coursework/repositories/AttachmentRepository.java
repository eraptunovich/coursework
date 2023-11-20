package com.example.coursework.repositories;

import com.example.coursework.models.IssueAttachments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface AttachmentRepository extends JpaRepository<IssueAttachments, Long> {
}
