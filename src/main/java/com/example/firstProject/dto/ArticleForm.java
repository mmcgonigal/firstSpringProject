package com.example.firstProject.dto;

import com.example.firstProject.model.Article;

public class ArticleForm {
     // form  on new.mustache has 2 field to fill in so it must have those 2 fields in this ArticleForm class

    private String title;
    private String description;



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

    public ArticleForm(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }


    public Article toEntity() {
        return new Article(null, title, description);
    }
}
