package com.fali.Controller;

import com.fali.Controller.api.ArticleApi;
import com.fali.Dto.ArticleDto;
import com.fali.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ArticleController implements ArticleApi {

    private ArticleService  articleService;
    @Autowired
    public ArticleController(ArticleService  articleService){
        this.articleService = articleService;
    }

    @Override
    public ArticleDto save(ArticleDto dto) {
        return articleService.save(dto);
    }

    @Override
    public ArticleDto findById(Long idArticle) {
        return articleService.findById(idArticle);
    }

    @Override
    public ArticleDto findByCodeArticle(String codeArticle) {
        return articleService.findByCodeArticle(codeArticle);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Long idArticle) {

        articleService.delete(idArticle);
    }
}
