package com.fali.Dto;

import java.util.List;


import com.fali.entites.Category;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Builder;
import lombok.Data;


//@Builder
@Data
public class CategoryDto {



	private Long idCategory;
	
	private String code;
	
	private String designation;
	@JsonIgnore
	private List<ArticleDto>  articlesDto;
	
	
	
	public static CategoryDto fromEntity(Category category) {
		
		if(category == null) {
			return null ;
					}
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setIdCategory(category.getIdCategory());
		categoryDto.setCode(category.getCode());
		categoryDto.setDesignation(category.getDesignation());
		return categoryDto;

	/*	return CategoryDto.builder()
				.idCategory(category.getIdCategory())
				.code(category.getCode())
				.designation(category.getDesignation())
				.build();*/
	}
	
	public static  Category toEntity(CategoryDto categoryDto) {
		if(categoryDto == null) {
			return null ;
					}
		 Category category = new Category();
		 category.setIdCategory(categoryDto.getIdCategory());
		 category.setCode(categoryDto.getCode());
		 category.setDesignation(categoryDto.getDesignation());
		 
		 
		return category ;
	}


}
