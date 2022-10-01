package com.fali.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeClient implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCommandeClient;
	@Column(name = "code")
	private String code;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datecommande")
	private Date dateCommande;

	@Column(name = "totalcommande")
	private BigDecimal totalCommande;
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	@OneToMany(mappedBy = "commandeClient")
	private List<LigneCommandeClient> ligneCommandeClients;
}
