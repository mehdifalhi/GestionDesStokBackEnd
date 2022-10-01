package com.fali.Dto;

import com.fali.entites.LigneVente;
//import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

//@Builder
@Data
public class LigneVenteDto {

	private Long idLigneVente;

	private BigDecimal quantite;

	private ArticleDto article;

	private VenteDto vente;

  public static  LigneVenteDto fromEntity(LigneVente ligneVente){
	  if(ligneVente== null){
		  return null;
	  }
	 LigneVenteDto ligneVenteDto = new LigneVenteDto();
	  ligneVenteDto.setIdLigneVente(ligneVente.getIdLigneVente());
	  ligneVenteDto.setQuantite(ligneVente.getQuantite());
	  ligneVenteDto.setArticle(ArticleDto.fromEntity(ligneVente.getArticle()));
	  ligneVenteDto.setVente(VenteDto.fromEntity(ligneVente.getVente()));
	  return ligneVenteDto;

	/*   return LigneVenteDto.builder()
			  .idLigneVente(ligneVente.getIdLigneVente())
			  .quantite(ligneVente.getQuantite())
			  .article(ArticleDto.fromEntity(ligneVente.getArticle()))
			  .vente(VenteDto.fromEntity(ligneVente.getVente()))
			  .build();*/
  }

  public static LigneVente toEntity(LigneVenteDto ligneVenteDto){
	  if(ligneVenteDto==null){
		  return null;
	  }

	  LigneVente ligneVente =new LigneVente();

	  ligneVente.setIdLigneVente(ligneVenteDto.getIdLigneVente());
	  ligneVente.setQuantite(ligneVenteDto.getQuantite());
	  ligneVente.setArticle(ArticleDto.toEntity(ligneVenteDto.getArticle()));
	  ligneVente.setVente(VenteDto.toEntity(ligneVenteDto.getVente()));

	  return ligneVente;
  }
	
}
