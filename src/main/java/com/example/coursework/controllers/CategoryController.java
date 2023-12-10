package com.example.coursework.controllers;

import com.example.coursework.models.IssueCategories;
import com.example.coursework.repositories.CategoryRepository;
import com.example.coursework.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;


@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository categoryRepository;
    private final CategoryService categoryService;

    @GetMapping("/category/create")
    public String category(){

        return "category-create"; //название представления
    }

    @PostMapping("/category/create")
    public String createCategory(IssueCategories category) throws IOException {
        categoryService.saveIssueCategory(category);

        return "redirect:/";
    }
}
