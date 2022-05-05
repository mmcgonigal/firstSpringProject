package com.example.firstProject.dto;

import com.example.firstProject.model.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class ArticleForm {
     // form  on new.mustache has 2 field to fill in so it must have those 2 fields in this ArticleForm class

    private String title;
    private String description;
    private Long id;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//
//    public ArticleForm(String title, String description) {
//        this.title = title;
//        this.description = description;
//    } --->  can be replaced with lombok annotation @AllArgsConstructor

//      ---> this as well, will be replaced with lombok annotation @ToString


    public Article toEntity() {
        return new Article(id, title, description);
    }
}
