package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fali.entites.Vente;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente,Long>{

   Optional<Vente> findVenteByCode(String code );

}
