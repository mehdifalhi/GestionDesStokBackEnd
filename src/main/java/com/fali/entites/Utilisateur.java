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
public class Utilisateur implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "mail")
	private String mail;

	@Column(name = "modedepasse")
	private String motDePasse;

	@Column(name = "photo")
	private String photo;

	@Column(name = "actived")
	private boolean actived;
	
	@OneToMany(mappedBy = "utilisateur")
	List<Roles> roles;

	


	
}
