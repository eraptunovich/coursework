package com.example.coursework.controllers;

import com.example.coursework.models.IssueAttachments;
import com.example.coursework.repositories.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentRepository attachmentRepository;

    @GetMapping("/images/{id}")
    private ResponseEntity<?> getAttachmentById(@PathVariable Long id){
        IssueAttachments image = attachmentRepository.findById(id).orElse(null);
        assert image != null;
        return ResponseEntity
                .ok()
                .header("fileName", image.getFileName())
                .contentType(MediaType.valueOf(image.getContentType()))
                .contentLength(image.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(image.getBytes())));
    }

}
