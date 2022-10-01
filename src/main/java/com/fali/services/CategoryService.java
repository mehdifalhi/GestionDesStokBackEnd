package com.fali.services;

import com.fali.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

     CategoryDto save(CategoryDto dto);

     CategoryDto findById(Long idCategory);

     CategoryDto findByCode(String code);

     List<CategoryDto> findAll();

    void  deleteById(Long idCategory);

}
