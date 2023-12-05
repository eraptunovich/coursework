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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;


    @GetMapping("/") //по данному гет-запросу будет вызываться данная функция
    public String issues(Model model, Principal principal){
        model.addAttribute("issues", issueService.listIssues());
        model.addAttribute("user", issueService.getUserByPrincipal(principal));
        return "issues"; //название представления
    }

    @GetMapping("/search/{id}")
    public String issueSearch(@RequestParam(name="title", required=true) String title, Model model){
        model.addAttribute("issues", issueService.getIssueByTitle(title));
        return "issue-search"; //название представления
    }

    @GetMapping("/issue/{id}")
    public String IssueInfo(@PathVariable Long id, Model model){

        Issue issue = issueService.getIssueById(id);
        model.addAttribute("issue", issue);
        System.out.println(issue.getAttachments());
        model.addAttribute("images", issue.getAttachments());
        return "issue-info";
    }

    @PostMapping("/issue/create")
    public String createIssue(@RequestParam("file1")  MultipartFile file1,
                              @RequestParam("file2") MultipartFile file2,
                              @RequestParam("file3") MultipartFile file3,
                              Issue issue,
                              Principal principal) throws IOException {

        issueService.saveIssue(principal, issue, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/issue/delete/{id}")
    public String deleteIssue(@PathVariable Long id) {
        issueService.deleteIssue(id);
        return "redirect:/";
    }

}
