package com.fali.Dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

	private Long idRole;
	
	private String roleName;

	private UtilisateurDto utilisateur;


	
	

}
