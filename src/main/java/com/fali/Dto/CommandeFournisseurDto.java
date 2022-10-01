package com.fali.Dto;

import com.fali.entites.CommandeFournisseur;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


//@Builder
@Data
public class CommandeFournisseurDto {
	
	private Long idCommandeFournisseur;

	private String code;
	
	private Date dateCommande;

	private FournisseurDto fournisseur;
	@JsonIgnore
	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
		if(commandeFournisseur==null){
			return null;
		}
		CommandeFournisseurDto commandeFournisseurDto =new CommandeFournisseurDto();
		commandeFournisseurDto.setIdCommandeFournisseur(commandeFournisseur.getIdCommandeFournisseur());
		commandeFournisseurDto.setDateCommande(commandeFournisseur.getDateCommande());
		commandeFournisseurDto.setFournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()));
		return commandeFournisseurDto;

	/*	return CommandeFournisseurDto.builder()
				.idCommandeFournisseur(commandeFournisseur.getIdCommandeFournisseur())
				.code(commandeFournisseur.getCode())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
			//	.ligneCommandeFournisseurs(LigneCommandeFournisseurDto.fromEntity(commandeFournisseur.getLigneCommandeFournisseurs()))
				.build();*/
	}

	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto ){
		if(commandeFournisseurDto==null){
			return null;
		}

		CommandeFournisseur commandeFournisseur =new CommandeFournisseur();
		commandeFournisseur.setIdCommandeFournisseur(commandeFournisseurDto.getIdCommandeFournisseur());
		commandeFournisseur.setCode(commandeFournisseurDto.getCode());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));

		 return commandeFournisseur;
	}





	
}
