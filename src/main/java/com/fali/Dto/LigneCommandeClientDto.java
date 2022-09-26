package com.fali.Dto;

import com.fali.entites.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class LigneCommandeClientDto {

	private Long idLigneCdeClt;

	private ArticleDto article;
	@JsonIgnore
	private CommandeClientDto commandeClient;

	private BigDecimal quantite;

	private BigDecimal prixUnitaire;

public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient){
	if(ligneCommandeClient == null){
		return null;
	}
	return LigneCommandeClientDto.builder()
			.idLigneCdeClt(ligneCommandeClient.getIdLigneCdeClt())
			.article(ArticleDto.fromEntity((ligneCommandeClient.getArticle())))
			//.commandeClient(CommandeClientDto.fromEntity(ligneCommandeClient.getCommandeClient()))
			.quantite(ligneCommandeClient.getQuantite())
			.prixUnitaire(ligneCommandeClient.getPrixUnitaire())
			.build();
}


public static LigneCommandeClient toEntity(LigneCommandeClientDto ligneCommandeClientDto){
	if(ligneCommandeClientDto==null){
		return null;

	}
	LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
	ligneCommandeClient.setIdLigneCdeClt(ligneCommandeClientDto.getIdLigneCdeClt());
	ligneCommandeClient.setArticle(ArticleDto.toEntity(ligneCommandeClientDto.getArticle()));
	//ligneCommandeClient.setCommandeClient(CommandeClientDto.toEntity(ligneCommandeClientDto.getCommandeClient()));
	ligneCommandeClient.setQuantite(ligneCommandeClientDto.getQuantite());
	ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDto.getPrixUnitaire());
	return ligneCommandeClient;
}
}
