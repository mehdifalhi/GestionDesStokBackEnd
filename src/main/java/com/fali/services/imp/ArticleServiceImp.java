package com.fali.services.imp;

import com.fali.Dto.ArticleDto;
import com.fali.entites.Article;
import com.fali.repositories.ArticleRepository;
import com.fali.services.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImp implements ArticleService {


    private ArticleRepository articleRepository ;

    @Autowired
    public  ArticleServiceImp( ArticleRepository articleRepository){

        this.articleRepository=articleRepository;

    }
    @Override
    public ArticleDto save(ArticleDto dto) {
        return ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(dto)));
    }

    @Override
    public ArticleDto findById(Long idArticle) {
        Optional<Article> article = articleRepository.findById(idArticle);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(() ->
                new RuntimeException("id not FOUND" + idArticle));
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(ArticleDto.fromEntity(article.get()))
                .orElseThrow(() ->
                new RuntimeException("code not FOUND" + codeArticle));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long idArticle) {

        articleRepository.deleteById(idArticle);
           }
}
