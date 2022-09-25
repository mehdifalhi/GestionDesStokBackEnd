package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long>{

}
