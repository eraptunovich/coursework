package com.example.coursework.controllers;

import com.example.coursework.models.IssueAttachments;
import com.example.coursework.repositories.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@RestController
@RequiredArgsConstructor
public class AttachmentController {
    private final AttachmentRepository attachmentRepository;

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getAttachmentById(@PathVariable Long id) {
        IssueAttachments image = attachmentRepository.findById(id).orElse(null);

        System.out.println(image);

        if (image == null) {
            return ResponseEntity.notFound().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf(image.getContentType()));
        headers.setContentLength(image.getSize());
        headers.setContentDispositionFormData("attachment", image.getFileName());
        headers.set(HttpHeaders.ACCEPT_RANGES, "bytes");

        // Добавлен try-catch для перехвата возможных ошибок
        try {
            System.out.println(headers);
            return new ResponseEntity<>(image.getBytes(), headers, HttpStatus.OK);
        } catch (Exception e) {
            // Логгирование ошибки или возврат ошибочного ответа
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



}
