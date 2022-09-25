package com.fali.Controller.api;

import com.fali.Dto.ArticleDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaTray;
import java.util.List;

public interface ArticleApi {

    @PostMapping(value = "/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value = "/article/{idArticle}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findById(@PathVariable  Long idArticle);

    @GetMapping(value = "/article/{codeArticle}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    ArticleDto findByCodeArticle(@PathVariable String codeArticle);

    @GetMapping(value = "/article/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> findAll();

    @DeleteMapping(value = "/article/delete/idArticle")
    void  delete(@PathVariable Long idArticle);
}
