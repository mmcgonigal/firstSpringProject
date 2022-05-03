package com.example.firstProject.repositories;

import com.example.firstProject.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article,Long> {
    @Override
    ArrayList<Article> findAll();
}
