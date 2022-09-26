package com.fali.repositories;


import org.springframework.data.jpa.repository.JpaRepository;


import com.fali.entites.CommandeFournisseur;

import java.util.Optional;


public interface ComFournisseurRepository extends JpaRepository<CommandeFournisseur,Long>{

    Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

}
