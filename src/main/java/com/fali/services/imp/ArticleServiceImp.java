package com.fali.services.imp;

import com.fali.Dto.ArticleDto;
import com.fali.entites.Article;
import com.fali.exception.EntityNotFoundException;
import com.fali.exception.ErrorsCodes;
import com.fali.repositories.ArticleRepository;
import com.fali.services.ArticleService;
//import com.fali.validator.ArticleValidator;
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
    public ArticleDto findById(Long id) {




         Optional<Article> article = articleRepository.findById(id);
         ArticleDto dto = ArticleDto.fromEntity(article.get());
        return Optional.of(dto).orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec l ID" +id+" n'est trouve dans lBDD",
                        ErrorsCodes.ARTICLE_NOT_FOUND));
   /*    if(idArticle==null){
            log.error("Article not found");
            return null;
        }
       return articleRepository.findById(idArticle)
                .map(ArticleDto::fromEntity)
                .orElseThrow(() ->
                        new EntityNotFoundException("Aucun article avec l ID" +idArticle+" n'est trouve dans lBDD",
                                ErrorsCodes.ARTICLE_NOT_FOUND));*/
    }

      @Override
      public ArticleDto findArticleByCodeArticle(String codeArticle) {
          Optional<Article> article = articleRepository.findArticleByCodeArticle(codeArticle);
        return Optional.of(ArticleDto.fromEntity(article.get()))
                .orElseThrow(() ->
                new EntityNotFoundException("Aucun article avec l code" +codeArticle+" n'est trouve dans lBDD",
                        ErrorsCodes.ARTICLE_NOT_FOUND));
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

        articleRepository.deleteById(id);
           }
}
