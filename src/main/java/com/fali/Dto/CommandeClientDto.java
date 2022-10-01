package com.fali.Dto;

import com.fali.entites.CommandeClient;
//import com.fali.entites.LigneCommandeClient;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


//@Builder
@Data
public class CommandeClientDto {
	
    private Long idCommandeClient;
	
	private String code;

	private Date dateCommande;
	
	private ClientDto clientDto;
    @JsonIgnore
	private List<LigneCommandeClientDto> ligneCommandeClients;

	private BigDecimal totalCommande;

  public  static CommandeClientDto fromEntity(CommandeClient commandeClient){
	  if(commandeClient == null){
		  return  null;
	  }
      CommandeClientDto commandeClientDto = new CommandeClientDto();
	  commandeClientDto.setIdCommandeClient(commandeClient.getIdCommandeClient());
	  commandeClientDto.setCode(commandeClientDto.getCode());
	  commandeClientDto.setDateCommande(commandeClient.getDateCommande());
	  commandeClientDto.setClientDto(ClientDto.fromEntity(commandeClient.getClient()));
	  commandeClientDto.setTotalCommande(commandeClient.getTotalCommande());
	  return commandeClientDto;

	 	/* return CommandeClientDto.builder()
			  .idCommandeClient(commandeClient.getIdCommandeClient())
			  .code(commandeClient.getCode())
			  .dateCommande(commandeClient.getDateCommande())
			  .clientDto(ClientDto.fromEntity(commandeClient.getClient()))
			 // .ligneCommandeClients(LigneCommandeClientDto.fromEntity(commandeClient.getLigneCommandeClients()))
			  .totalCommande(commandeClient.getTotalCommande())
			  .build();*/
  }

  public static CommandeClient toEntity(CommandeClientDto commandeClientDto){
	  if(commandeClientDto == null){
		  return null;
	  }

	  CommandeClient commandeClient = new CommandeClient();

	  commandeClient.setIdCommandeClient(commandeClientDto.getIdCommandeClient());
	  commandeClient.setCode(commandeClientDto.getCode());
	  commandeClient.setDateCommande(commandeClientDto.getDateCommande());
	  commandeClient.setClient(ClientDto.toEntity(commandeClientDto.getClientDto()));
	  commandeClient.setTotalCommande(commandeClientDto.getTotalCommande());
	  return commandeClient;
  }


	
	


}
