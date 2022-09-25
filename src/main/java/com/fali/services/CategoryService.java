package com.fali.services;

import com.fali.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    public CategoryDto save(CategoryDto dto);

    public CategoryDto findById(Long idCategory);

    public CategoryDto findByCode(String code);

    public List<CategoryDto> findAll();

    void  deleteById(Long idCategory);

}
