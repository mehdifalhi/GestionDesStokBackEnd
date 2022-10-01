package com.fali.Controller.api;



import com.fali.Dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api("/categories")
public interface CategoryApi {
    @PostMapping(value ="/categories/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregister un categorie",notes = "Cette methode permet d'enregister ou modifier un categorie",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "L'objet categorie cree/ modifier")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value ="/categories/{idCategory}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un categorie",notes = "Cette methode permet de chercher un categorie par son ID",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "La categorie a ete trouve dans la BDD")
    })
    CategoryDto findById(@RequestParam(value = "idCategory",required = false) Long idCategory);

    @GetMapping(value ="/categories/{code}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un categorie",notes = "Cette methode permet de chercher un categorie par son CODE",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "La categorie a ete trouve dans la BDD")
    })
    CategoryDto findByCode(@RequestParam(value = "code",required = false) String code);

    @GetMapping(value ="/categories/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un categorie",notes = "Cette methode permet de chercher des categories ",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "Les categories sont trouve dans la BDD")
    })
    List<CategoryDto> findAll();

    @DeleteMapping(value ="/categories/delete/{idCategory}")
    @ApiOperation(value = "Suppression un categorie",notes = "Cette methode permet de supprimer un categorie par son ID",response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(code=200,message = "La categorie a ete supprimer dans la BDD")
    })
    void  delete(@PathVariable Long idCategory);
}
