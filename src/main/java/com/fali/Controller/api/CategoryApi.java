package com.fali.Controller.api;

import com.fali.Dto.ArticleDto;
import com.fali.Dto.CategoryDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CategoryApi {
    @PostMapping(value = "/categorys/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = "/categorys/{idCategory}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findById(@PathVariable Long idCategory);

    @GetMapping(value = "/gategorys/{code}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDto findByCode(@PathVariable String code);

    @GetMapping(value = "/categorys/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDto> findAll();

    @DeleteMapping(value = "/categorys/delete/idCategory")
    void  delete(@PathVariable Long idCategory);
}
