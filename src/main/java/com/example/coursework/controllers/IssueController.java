package com.example.coursework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IssueController {
    @GetMapping("/") //по данному гет-запросу будет вызываться данная функция
    public String issues(){
        return "issues"; //название представления
    }
}
