package com.fali.Controller.api;

import com.fali.Dto.ArticleDto;/*
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;*/

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Api("/articles")
public interface ArticleApi {

    @PostMapping(value ="/articles/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister un article",notes = "Cette methode permet d'enregister ou modifier un article",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'objet article cree/ modifier")
    })
     ArticleDto save(@RequestBody ArticleDto dto);

    @GetMapping(value ="/articles/{idArticle}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article",notes = "Cette methode permet de chercher un article par son ID",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'article a ete trouve dans la BDD")
    })
    ArticleDto findById(@RequestParam(value = "idArticle",required = false)  Long id);

   @GetMapping(value ="/articles/{codeArticle}" ,produces = MediaType.APPLICATION_JSON_VALUE)
   @ApiOperation(value = "Rechercher un article",notes = "Cette methode permet de chercher un article par son CODE",response = ArticleDto.class)
   @ApiResponses(value = {
           @ApiResponse(code=200,message = "L'article a ete trouve dans la BDD")
   })
    ArticleDto findArticleByCodeArticle(@RequestParam("codeArticle") String code);

    @GetMapping(value ="/articles/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister un article",notes = "Cette methode permet de cherche tout Les articles",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "Les articles sont  trouve dans la BDD")
    })
    List<ArticleDto> findAll();

    @DeleteMapping(value ="/articles/delete/{idArticle}")
    @ApiOperation(value = "Suppression un article",notes = "Cette methode permet de supprimer un article",response = ArticleDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'aricle a ete supprimer dans la BDD")
    })
    void  delete(@PathVariable("idArticle") Long id);
}
