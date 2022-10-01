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
public class Category  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	@Column(name = "code")
	private String code;
	@Column(name = "designation")
	private String designation;
	
	@OneToMany(mappedBy = "category")
	private List<Article> articles;
	
	
	

}
