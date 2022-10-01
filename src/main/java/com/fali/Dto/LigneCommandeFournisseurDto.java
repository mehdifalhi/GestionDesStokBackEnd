package com.fali.Dto;


import com.fali.entites.LigneCommandeFournisseur;
//import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

//@Builder
@Data
public class LigneCommandeFournisseurDto {

	private Long idLigneCdeFrs;

	private BigDecimal quantite;

	private BigDecimal prixUnitaire;
	
	private ArticleDto article;

	private CommandeFournisseurDto commandeFournisseur;

	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
		if(ligneCommandeFournisseur==null){
			return null;
		}
		LigneCommandeFournisseurDto ligneCommandeFournisseurDto = new LigneCommandeFournisseurDto();
		ligneCommandeFournisseurDto.setIdLigneCdeFrs(ligneCommandeFournisseur.getIdLigneCdeFrs());
		ligneCommandeFournisseurDto.setQuantite(ligneCommandeFournisseur.getQuantite());
		ligneCommandeFournisseurDto.setPrixUnitaire(ligneCommandeFournisseur.getPrixUnitaire());
		ligneCommandeFournisseurDto.setArticle(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()));
		return ligneCommandeFournisseurDto;

		/*return LigneCommandeFournisseurDto.builder()
				.idLigneCdeFrs(ligneCommandeFournisseur.getIdLigneCdeFrs())
				.quantite(ligneCommandeFournisseur.getQuantite())
				.prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
				.build();*/
	}

	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
		if(ligneCommandeFournisseurDto==null){
			return null;
		}

		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setIdLigneCdeFrs(ligneCommandeFournisseurDto.getIdLigneCdeFrs());
		ligneCommandeFournisseur.setQuantite(ligneCommandeFournisseurDto.getQuantite());
		ligneCommandeFournisseur.setPrixUnitaire(ligneCommandeFournisseurDto.getPrixUnitaire());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
		return ligneCommandeFournisseur;
	}



	
}
