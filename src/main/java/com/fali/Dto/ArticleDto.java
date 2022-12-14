package com.fali.Dto;

import java.math.BigDecimal;


import com.fali.entites.Article;



import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class ArticleDto {

	private Long idArticle;

	private String codeArticle;

	private String designation;

	private BigDecimal prixUnitaireHT;

	private BigDecimal tauxTva;

	private BigDecimal prixUnitaireTTC;

	private String photo;


	private CategoryDto category;
	
	
	
	public static ArticleDto fromEntity(Article article) {
		if(article == null) {
			return null;
		}
/*		ArticleDto articleDto = new ArticleDto();
		articleDto.setIdArticle(article.getIdArticle());
		articleDto.setCodeArticle(article.getCodeArticle());
		articleDto.setDesignation(article.getDesignation());
		articleDto.setPrixUnitaireHT(article.getPrixUnitaireHT());
		articleDto.setTauxTva(article.getTauxTva());
		articleDto.setPhoto(article.getPhoto());
		articleDto.setCategory(CategoryDto.fromEntity(article.getCategory()));
		return articleDto;*/

		return ArticleDto.builder()
				.idArticle(article.getIdArticle())
				.codeArticle(article.getCodeArticle())
				.designation(article.getDesignation())
				.prixUnitaireHT(article.getPrixUnitaireHT())
				.tauxTva(article.getTauxTva())
				.prixUnitaireTTC(article.getPrixUnitaireTTC())
				.photo(article.getPhoto())
				.category(CategoryDto.fromEntity(article.getCategory()))
				.build();
		
	}
	
	public static Article toEntity(ArticleDto articleDto) {
		
		if(articleDto == null) {
			return null;
		}
		
		Article article = new Article();
		article.setIdArticle(articleDto.getIdArticle());
		article.setCodeArticle(articleDto.getCodeArticle());
		article.setDesignation(articleDto.getDesignation());
		article.setPrixUnitaireHT(articleDto.getPrixUnitaireHT());
		article.setTauxTva(articleDto.getTauxTva());
		article.setPrixUnitaireTTC(articleDto.getPrixUnitaireTTC());
		article.setPhoto(articleDto.getPhoto());
		article.setCategory(CategoryDto.toEntity(articleDto.getCategory()));

		
		return article;
		
	}

	

}
