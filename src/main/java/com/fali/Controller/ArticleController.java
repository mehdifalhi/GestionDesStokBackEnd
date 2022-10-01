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
    public ArticleDto findById(Long id) {
        return articleService.findById(id);
    }

      @Override
    public ArticleDto findArticleByCodeArticle(String code) {
        return articleService.findArticleByCodeArticle(code);
    }

    @Override
    public List<ArticleDto> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Long id) {

        articleService.deleteById(id);
    }
}
