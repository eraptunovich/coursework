package com.example.coursework.services;

import com.example.coursework.models.Issue;
import com.example.coursework.models.IssueAttachments;
import com.example.coursework.models.User;
import com.example.coursework.repositories.IssueRepository;
import com.example.coursework.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IssueService {
    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public List<Issue> listIssues() {
        return issueRepository.findAll();
    }


    public void saveIssue(Principal principal, Issue issue, MultipartFile f1, MultipartFile f2, MultipartFile f3) throws IOException {
        issue.setUser(getUserByPrincipal(principal));
        IssueAttachments img1;
        IssueAttachments img2;
        IssueAttachments img3;
        if(f1.getSize()!=0){
            System.out.println(f1.getSize());
            img1 = toImageEntity(f1);
            img1.setPreviewImage(true);
            issue.addImageToIssue(img1);
        }
        if(f2.getSize()!=0){
            img2 = toImageEntity(f2);
            img2.setPreviewImage(true);
            issue.addImageToIssue(img2);
        }
        if(f3.getSize()!=0){
            img3 = toImageEntity(f3);
            img3.setPreviewImage(true);
            issue.addImageToIssue(img3);
        }
        log.info("Saving new issue. Title: {}, Description: {}", issue.getTitle(), issue.getDescription());
        Issue issueFromDb = issueRepository.save(issue);
        if(!issueFromDb.getAttachments().isEmpty()) issueFromDb.setPreviewImageId(issueFromDb.getAttachments().get(0).getAttachmentId());
        issueRepository.save(issue);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null){
            return new User();
        }
        return userRepository.findByLogin(principal.getName());
    }

    private IssueAttachments toImageEntity(MultipartFile file) {
        try {
            IssueAttachments image = new IssueAttachments();
            image.setFileName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setSize(file.getSize());
            image.setBytes(file.getBytes());
            return image;
        } catch (IOException e) {
            log.error("Error converting MultipartFile to IssueAttachments. File name: {}, Content type: {}, Size: {} bytes",
                    file.getOriginalFilename(), file.getContentType(), file.getSize());
            throw new RuntimeException("Error converting MultipartFile to IssueAttachments", e);
        }
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
