package com.fali.services.imp;

import com.fali.Dto.CategoryDto;
import com.fali.entites.Category;
import com.fali.repositories.CategoryRepository;
import com.fali.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class CategoryServiceImp implements CategoryService {


    private CategoryRepository  categoryRepository;
    @Autowired
    public  CategoryServiceImp(CategoryRepository  categoryRepository){
        this.categoryRepository=categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return CategoryDto.fromEntity(categoryRepository.save(CategoryDto.toEntity(dto)));
    }

    @Override
    public CategoryDto findById(Long idCategory) {
        Optional<Category> category = categoryRepository.findById(idCategory);
        return Optional.of(CategoryDto.fromEntity(category.get()))
                .orElseThrow(() ->
                        new RuntimeException("id not FOUND" + idCategory));
    }

    @Override
    public CategoryDto findByCode(String code) {
        Optional<Category> category = categoryRepository.findCategoryByCode(code);
        return Optional.of(CategoryDto.fromEntity(category.get()))
                .orElseThrow(() ->
                        new RuntimeException("code not FOUND" + code));
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
