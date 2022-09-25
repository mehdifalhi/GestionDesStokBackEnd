package com.fali.Dto;


import com.fali.entites.LigneCommandeFournisseur;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LigneCommandeFournisseurDto {

	private Long idLigneCdeFrs;

	
	private ArticleDto article;

	private CommandeFournisseurDto commandeFournisseur;

	public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur){
		if(ligneCommandeFournisseur==null){
			return null;
		}
		return LigneCommandeFournisseurDto.builder()
				.idLigneCdeFrs(ligneCommandeFournisseur.getIdLigneCdeFrs())
				.article(ArticleDto.fromEntity(ligneCommandeFournisseur.getArticle()))
				.commandeFournisseur(CommandeFournisseurDto.fromEntity(ligneCommandeFournisseur.getCommandeFournisseur()))
				.build();
	}

	public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto ligneCommandeFournisseurDto){
		if(ligneCommandeFournisseurDto==null){
			return null;
		}

		LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
		ligneCommandeFournisseur.setIdLigneCdeFrs(ligneCommandeFournisseurDto.getIdLigneCdeFrs());
		ligneCommandeFournisseur.setArticle(ArticleDto.toEntity(ligneCommandeFournisseurDto.getArticle()));
		ligneCommandeFournisseur.setCommandeFournisseur(CommandeFournisseurDto.toEntity(ligneCommandeFournisseurDto.getCommandeFournisseur()));
		return ligneCommandeFournisseur;
	}



	
}
