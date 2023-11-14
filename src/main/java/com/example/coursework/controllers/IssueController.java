package com.example.coursework.controllers;

import com.example.coursework.models.Issue;
import com.example.coursework.services.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;


    @GetMapping("/") //по данному гет-запросу будет вызываться данная функция
    public String issues(@RequestParam(name="title", required=false) String title, Model model){
        model.addAttribute("issues", issueService.listIssues(title));
        return "issues"; //название представления
    }

    @GetMapping("/issue/{id}")
    public String IssueInfo(@PathVariable Long id, Model model){
        Issue issue = issueService.getIssueById(id);
        model.addAttribute("issue", issue);
        return "issue-info";
    }

    @PostMapping("/issue/create")
    public String createIssue(Issue issue){
        issueService.saveIssue(issue);
        return "redirect:/";
    }

    @PostMapping("/issue/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        issueService.deleteIssue(id);
        return "redirect:/";
    }


}
