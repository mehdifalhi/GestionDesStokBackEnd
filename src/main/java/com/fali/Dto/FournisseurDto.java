package com.fali.Dto;

import java.util.List;


import com.fali.entites.Fournisseur;


import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class FournisseurDto {
	
private Long idFournisseur;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String photo;
	
	private String mail;

	@JsonIgnore
	private List<CommandeFournisseurDto> commandeFournisseurs;
	
	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		if (fournisseur == null) {
			return null;
		}

	FournisseurDto fournisseurDto = new FournisseurDto();
		fournisseurDto.setIdFournisseur(fournisseur.getIdFournisseur());
		fournisseurDto.setNom(fournisseur.getNom());
		fournisseurDto.setPrenom(fournisseur.getPrenom());
		fournisseurDto.setAdresse(fournisseur.getAdresse());
		fournisseurDto.setPhoto(fournisseur.getPhoto());
		fournisseurDto.setMail(fournisseur.getMail());
		return fournisseurDto;
		/*return FournisseurDto.builder()
				.idFournisseur(fournisseur.getIdFournisseur())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.adresse(fournisseur.getAdresse())
				.photo(fournisseur.getPhoto())
				.mail(fournisseur.getMail())
				.build();*/

	}
	
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		
		if (fournisseurDto == null) {
			return null;
		}
		
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdFournisseur(fournisseurDto.getIdFournisseur());
		fournisseur.setNom(fournisseurDto.getNom());
		fournisseur.setPrenom(fournisseurDto.getPrenom());
		fournisseur.setAdresse(fournisseurDto.getAdresse());
		fournisseur.setMail(fournisseurDto.getMail());
		fournisseur.setPhoto(fournisseurDto.getPhoto());
		return fournisseur;
		
	}



}
