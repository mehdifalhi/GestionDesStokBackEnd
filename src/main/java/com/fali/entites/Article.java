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
public class Article  implements Serializable  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticle;
	@Column(name = "codearticle")
	private String codeArticle;
	@Column(name = "designation")
	private String designation;
	@Column(name = "prixunitaireht")
	private BigDecimal prixUnitaireHT;
	@Column(name = "tauxtva")
	private BigDecimal tauxTva;
	@Column(name = "prixniutairettc")
	private BigDecimal prixUnitaireTTC;
	@Column(name = "photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;


	

}
