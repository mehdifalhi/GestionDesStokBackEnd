package com.fali.Dto;

import com.fali.entites.LigneVente;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneVenteDto {

	private Long idLigneVente;

	
	private ArticleDto article;

	private VenteDto vente;

  public static  LigneVenteDto fromEntity(LigneVente ligneVente){
	  if(ligneVente== null){
		  return null;
	  }
	  return LigneVenteDto.builder()
			  .idLigneVente(ligneVente.getIdLigneVente())
			  .article(ArticleDto.fromEntity(ligneVente.getArticle()))
			  .vente(VenteDto.fromEntity(ligneVente.getVente()))
			  .build();
  }

  public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
	  if(ligneVenteDto==null){
		  return null;
	  }

	  LigneVente ligneVente =new LigneVente();

	  ligneVente.setIdLigneVente(ligneVenteDto.getIdLigneVente());
	  ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
	  ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));

	  return ligneVente;
  }
	
}
