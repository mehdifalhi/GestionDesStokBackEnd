package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeClient implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneCdeClt;

	@Column(name ="quantite")
	private BigDecimal quantite;

	@Column(name ="prixUnitaire")
	private BigDecimal prixUnitaire;


	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "idCommandeClient")
	private CommandeClient commandeClient;


	
	


}
