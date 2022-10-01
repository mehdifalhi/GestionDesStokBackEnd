package com.fali.Dto;

import java.util.List;


import com.fali.entites.Utilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class UtilisateurDto {

	private Long idUtilisateur;

	private String nom;

	private String prenom;

	private String mail;

	private String motDePasse;

	private String photo;

	private boolean actived;
	@JsonIgnore
	List<RolesDto> roles;
	
	
	public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
		if (utilisateur == null) {
			return null;
		}

          UtilisateurDto utilisateurDto = new UtilisateurDto();
		utilisateurDto.setIdUtilisateur(utilisateur.getIdUtilisateur());
		utilisateurDto.setNom(utilisateur.getNom());
		utilisateurDto.setPrenom(utilisateur.getPrenom());
		utilisateurDto.setMotDePasse(utilisateur.getMotDePasse());
		utilisateurDto.setPhoto(utilisateur.getPhoto());
		utilisateurDto.setMail(utilisateur.getMail());
		return utilisateurDto;
	/*	return UtilisateurDto.builder()
				.idUtilisateur(utilisateur.getIdUtilisateur())
				.nom(utilisateur.getNom())
				.prenom(utilisateur.getPrenom())
				.motDePasse(utilisateur.getMotDePasse())
				.photo(utilisateur.getPhoto())
				.mail(utilisateur.getMail())
				.build();*/

	}
	
	public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
		
		if (utilisateurDto == null) {
			return null;
		}
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdUtilisateur(utilisateurDto.getIdUtilisateur());
		utilisateur.setNom(utilisateurDto.getNom());
		utilisateur.setPrenom(utilisateurDto.getPrenom());
		utilisateur.setMotDePasse(utilisateurDto.getMotDePasse());
		utilisateur.setMail(utilisateurDto.getMail());
		utilisateur.setPhoto(utilisateurDto.getPhoto());
		
		return utilisateur;
		
		
	}


}
