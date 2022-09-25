package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.CommandeFournisseur;





public interface ComFournisseurRepository extends JpaRepository<CommandeFournisseur,Long>{

}
