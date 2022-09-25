package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeFournisseur implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idCommandeFournisseur;
		
		@Temporal(TemporalType.TIMESTAMP)
		private Date dateCommande;
		
		@ManyToOne
		@JoinColumn(name = "idFournisseur")
		private Fournisseur fournisseur;
		
		
		
		@OneToMany(mappedBy = "commandeFournisseur")
		private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;


}
