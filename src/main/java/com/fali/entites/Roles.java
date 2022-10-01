package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;

	@Column(name = "rolename")
	private String roleName;
	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateur;



}
