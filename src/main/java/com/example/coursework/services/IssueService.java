package com.example.coursework.services;

import com.example.coursework.models.Issue;
import com.example.coursework.repositories.IssueRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j //Логирование
public class IssueService {
    private final IssueRepository issueRepository;

    public List<Issue> listIssues(String title){
        if(title!= null) issueRepository.findByTitle(title);
        return issueRepository.findAll();
    }

    public void saveIssue(Issue issue){
        log.info("Saving new issue {}", issue);
        issueRepository.save(issue);
    }

    public void deleteIssue(Long id){
        issueRepository.deleteById(id);
    }

    public Issue getIssueById(Long id){
        return issueRepository.findById(id).orElse(null); //если не нашли объект, то возвращаем null
    }


}
