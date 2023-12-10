package com.example.coursework.services;

import com.example.coursework.models.Issue;
import com.example.coursework.models.IssueAttachments;
import com.example.coursework.models.IssueCategories;
import com.example.coursework.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<IssueCategories> listCategories() {
        return categoryRepository.findAll();
    }

    public void deleteIssueCategories(Long id){
        categoryRepository.deleteById(id);
    }

    public IssueCategories getIssueCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null); //если не нашли объект, то возвращаем null
    }

    public void saveIssueCategory(IssueCategories category) throws IOException {
        log.info("Saving new category. Title: {}", category.getCategoryName());
        categoryRepository.save(category);
    }
}
