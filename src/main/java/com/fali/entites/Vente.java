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
public class Vente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVente;

	@Column(name = "code")
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datevente")
	private Date dateVente;
	
	@OneToMany(mappedBy = "vente")
	private List<LigneVente> ligneVentes;
	
	

	

	
	}
