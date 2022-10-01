package com.fali.Dto;

import java.util.List;

import com.fali.entites.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.Builder;
import lombok.Data;

//@Builder
@Data
public class ClientDto {

	private Long idClient;

	private String nom;

	private String prenom;

	private String adresse;

	private String photo;

	private String mail;
	@JsonIgnore
	private List<CommandeClientDto> commandeClientsDto;

	public static ClientDto fromEntity(Client client) {
		if (client == null) {
			return null;
		}
		ClientDto clientDto = new ClientDto();
		clientDto.setIdClient(client.getIdClient());
		clientDto.setNom(client.getNom());
		clientDto.setPrenom(client.getPrenom());
		clientDto.setAdresse(client.getAdresse());
		clientDto.setPhoto(client.getPhoto());
		clientDto.setMail(client.getMail());

		return clientDto;

		/*return ClientDto.builder()
				.idClient(client.getIdClient())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.adresse(client.getAdresse())
				.photo(client.getPhoto())
				.mail(client.getMail())
				.build();*/

	}
	
	public static Client toEntity(ClientDto clientDto) {
		
		if (clientDto == null) {
			return null;
		}
		
		Client client = new Client();
		client.setIdClient(clientDto.getIdClient());
		client.setNom(clientDto.getNom());
		client.setPrenom(clientDto.getPrenom());
		client.setAdresse(clientDto.getAdresse());
		client.setMail(clientDto.getMail());
		client.setPhoto(clientDto.getPhoto());
		return client;
		
	}

}
