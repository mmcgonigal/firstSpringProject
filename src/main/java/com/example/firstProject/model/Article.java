package com.example.firstProject.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@ToString
public class Article {

    @Id // 대표값 지정, like a 주민등록 번호
    @GeneratedValue //1,2,3, .... 자동 생성 annotation
    private Long id;

    @Column
    private String title;
    private String description;

//    public Article(Long id, String title, String description){
//        this.id=id;
//        this.title=title;
//        this.description = description;
//    }
//
//
    public Article() {

    }
//
//    @Override
//    public String toString() {
//        return "Article{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
}
