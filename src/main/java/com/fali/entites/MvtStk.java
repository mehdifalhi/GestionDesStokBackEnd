package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MvtStk implements Serializable{
	
	public static final int ENTREE = 1;
	
	public static final int SORTIE = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMvtStk;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datemvt")
	private Date dateMvt;

	@Column(name = "quantite")
	private BigDecimal quantite;

	@Column(name = "typemvt")
	private int typeMvt;
	
	@ManyToOne
	@JoinColumn(name = "idArticle")
	private Article article;
	

	
	

}
