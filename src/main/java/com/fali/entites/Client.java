package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "photo")
	private String photo;
	@Column(name = "mail")
	private String mail;
	
	@OneToMany(mappedBy = "client")
	private List<CommandeClient> commandeClients;
	
	
	

}
