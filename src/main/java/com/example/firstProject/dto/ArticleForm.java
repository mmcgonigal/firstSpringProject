package com.example.firstProject.dto;

public class ArticleForm {
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
}
