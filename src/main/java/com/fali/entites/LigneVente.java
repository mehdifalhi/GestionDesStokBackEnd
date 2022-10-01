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
public class LigneVente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneVente;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;

	@Column(name = "quantite")
	private BigDecimal quantite;
	
	@ManyToOne
	@JoinColumn(name = "idVente")
	private Vente vente;

}
