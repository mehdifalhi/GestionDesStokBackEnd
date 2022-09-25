package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.Article;

import java.util.Optional;



public interface ArticleRepository extends JpaRepository<Article,Long>{

    Optional<Article> findArticleByCodeArticle(String codeArticle);
}
