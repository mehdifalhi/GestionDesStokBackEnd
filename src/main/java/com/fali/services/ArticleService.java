package com.fali.services;

import com.fali.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

     ArticleDto save(ArticleDto dto);

     ArticleDto findById(Long id);

     ArticleDto findArticleByCodeArticle(String codeArticle);

     List<ArticleDto> findAll();

     void  deleteById(Long id);
}
