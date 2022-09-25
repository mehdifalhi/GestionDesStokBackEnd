package com.fali.Dto;

import com.fali.entites.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Builder
@Data
public class CommandeFournisseurDto {
	
	private Long idCommandeFournisseur;
	
	
	private Date dateCommande;
	
	
	private FournisseurDto fournisseur;
	
	
	

	private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs;


	public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
		if(commandeFournisseur==null){
			return null;
		}
		return CommandeFournisseurDto.builder()
				.idCommandeFournisseur(commandeFournisseur.getIdCommandeFournisseur())
				.dateCommande(commandeFournisseur.getDateCommande())
				.fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()))
			//	.ligneCommandeFournisseurs(LigneCommandeFournisseurDto.fromEntity(commandeFournisseur.getLigneCommandeFournisseurs()))
				.build();
	}

	public static CommandeFournisseur toEntity(CommandeFournisseurDto commandeFournisseurDto ){
		if(commandeFournisseurDto==null){
			return null;
		}

		CommandeFournisseur commandeFournisseur =new CommandeFournisseur();
		commandeFournisseur.setIdCommandeFournisseur(commandeFournisseurDto.getIdCommandeFournisseur());
		commandeFournisseur.setDateCommande(commandeFournisseurDto.getDateCommande());
		commandeFournisseur.setFournisseur(FournisseurDto.toEntity(commandeFournisseurDto.getFournisseur()));

		 return commandeFournisseur;
	}





	
}
