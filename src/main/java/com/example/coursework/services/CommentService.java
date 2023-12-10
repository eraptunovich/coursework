package com.example.coursework.services;

import com.example.coursework.models.IssueCategories;
import com.example.coursework.models.IssueComments;
import com.example.coursework.repositories.CategoryRepository;
import com.example.coursework.repositories.CommentRepository;

import java.io.IOException;
import java.util.List;

public class CommentService {
    private CommentRepository commentRepository;

    public List<IssueComments> listCategories() {
        return commentRepository.findAll();
    }

    public void deleteIssueCategories(Long id){
        commentRepository.deleteById(id);
    }

    public IssueComments getIssueCommentsById(Long id){
        return commentRepository.findById(id).orElse(null); //если не нашли объект, то возвращаем null
    }

    public void saveIssueComment(IssueComments comment) throws IOException {
        log.info("Saving new category. Title: {}", comment.getCategoryName());
        categoryRepository.save(category);
    }
}
