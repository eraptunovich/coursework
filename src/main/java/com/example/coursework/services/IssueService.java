package com.example.coursework.services;

import com.example.coursework.models.Issue;
import com.example.coursework.models.IssueAttachments;
import com.example.coursework.repositories.IssueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueService {
    private final IssueRepository issueRepository;


    public List<Issue> listIssues() {
        return issueRepository.findAll();
    }


    public void saveIssue(Issue issue, MultipartFile f1, MultipartFile f2, MultipartFile f3) throws IOException {
        IssueAttachments img1;
        IssueAttachments img2;
        IssueAttachments img3;
        if(f1.getSize()!=0){
            img1 = toImageEntity(f1);
        }
        log.info("Saving new issue {}", issue);
        issueRepository.save(issue);
    }

    private IssueAttachments toImageEntity(MultipartFile file) throws IOException {
        IssueAttachments image = new IssueAttachments();
        image.setFileName(file.getOriginalFilename()); // Используйте getOriginalFilename() для получения имени файла
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }


    public void deleteIssue(Long id){
        issueRepository.deleteById(id);
    }

    public Issue getIssueById(Long id){
        return issueRepository.findById(id).orElse(null); //если не нашли объект, то возвращаем null
    }

    public List<Issue> getIssueByTitle(String title){
        return issueRepository.findByTitle(title);

    }


}
