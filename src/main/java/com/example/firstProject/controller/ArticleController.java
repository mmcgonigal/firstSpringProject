package com.example.firstProject.controller;


import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.model.Article;
import com.example.firstProject.repositories.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j // Simple logging Facade for java ; 심플 로딩 파사드 포 로깅 for logging...
public class ArticleController {
    @Autowired // 스프링 부트가 미리 생성해 놓은 객체를 가져다가 자동 연결
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }

    @PostMapping("/articles/create") // on new.mustache, form method is post  and thats why it is postmapping
    public String createForm(ArticleForm form){
        // name= "title" , name="description" 2 field will be in this instance

//        System.out.println(form.toString());
        //sout --> this is not recommended in real server and it does not leave any record. so will replace with logging

        log.info(form.toString());





        // 1. dto to Entity dto 를 변환 -> entity
        Article article = form.toEntity();

        // 2. let Rpository save Entity into DB
        Article saved =  articleRepository.save(article);
       // System.out.println(saved);

        log.info(saved.toString());

        return "";
    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model ){
        log.info("id = " +id);

        //1. find data by id
//        Optional<Article> article = articleRepository.findById(id);
        // return type is not Article , but  return as Optional<Article>  OR ... i could do this
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //--> if the data with this id does not exist, then return null

        //2. add data to model
         model.addAttribute("article",articleEntity);

        //3. set the view page
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1 , brind all List of Article

//        List<Article>articleEntityList = (List<Article>) articleRepository.findAll();
        //-----> articleRepository.findAll is not same type as List<Article> so i can cast it by (List<Article>)


        //OR ------> we could get those data as ArrayList . --> go to ArticleRepository interface and add @Override
        List<Article>articleEntityList = articleRepository.findAll();
        //---> even if i override interface method as ArrayList, I can still use List because it is upperClass than ArrayList

        //2 .  send those List of  Article to view
        model.addAttribute("articleList",articleEntityList);

        //3.set view page

        return "articles/index";
    }
}
