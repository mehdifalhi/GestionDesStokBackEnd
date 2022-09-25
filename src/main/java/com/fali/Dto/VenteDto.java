package com.fali.Dto;

import java.util.Date;
import java.util.List;

import com.fali.entites.Vente;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class VenteDto {

	private Long idVente;

	private String code;

	private Date dateVente;


	private List<LigneVenteDto> ligneVentes;
	
	public static VenteDto fromEntity(Vente vente) {
		
		if(vente == null) {
			
			return null;
		}
		
		
		return VenteDto.builder()
				.idVente(vente.getIdVente())
				.code(vente.getCode())
				.dateVente(vente.getDateVente())
				.build();
	}
	
	public static Vente toEntity(VenteDto venteDto) {
		
		if(venteDto == null) {
			return null;
		}
		
		Vente vente = new Vente();
		
		vente.setIdVente(venteDto.getIdVente());
		vente.setCode(venteDto.getCode());
		vente.setDateVente(venteDto.getDateVente());
		
		return null;
		
		
	}


}
