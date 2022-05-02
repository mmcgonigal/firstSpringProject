package com.example.firstProject.controller;


import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.model.Article;
import com.example.firstProject.repositories.ArticleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create") // on new.mustache, form method is post  and thats why it is postmapping
    public String createForm(ArticleForm form){
        // name= "title" , name="description" 2 field will be in this instance
        System.out.println(form.toString());

        // 1. dto to Entity dto 를 변환 -> entity
        Article article = form.toEntity();

        // 2. let Rpository save Entity into DB
        Article saved =  articleRepository.save(article);

        return "";
    }
}
