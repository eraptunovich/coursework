package com.example.coursework.services;

import com.example.coursework.models.Issue;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IssueService {
    private List<Issue> issues = new ArrayList<>();
    {
        issues.add(new Issue(1, "1", "1", 1,
                "1", "1", "1", "1", "1",
                "1", 1, 1 ));
        issues.add(new Issue(2, "2", "2", 2,
                "2", "2", "2", "2", "2",
                "2", 2, 2 ));
    }

}
