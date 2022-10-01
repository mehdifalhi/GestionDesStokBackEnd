package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fali.entites.Article;

import java.util.Optional;



public interface ArticleRepository extends JpaRepository<Article,Long>{

   Optional<Article> findArticleByCodeArticle(String codeArticle);
}
