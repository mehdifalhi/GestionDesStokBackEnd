package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeFournisseur implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCommandeFournisseur;

		@Column(name = "code")
		private String code;
		
		@Temporal(TemporalType.TIMESTAMP)
		@Column(name = "datecommande")
		private Date dateCommande;
		
		@ManyToOne
		@JoinColumn(name = "idFournisseur")
		private Fournisseur fournisseur;
		
		
		
		@OneToMany(mappedBy = "commandeFournisseur")
		private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}
