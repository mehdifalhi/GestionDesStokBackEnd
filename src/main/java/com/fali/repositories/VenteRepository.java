package com.fali.repositories;

import com.fali.Dto.VenteDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.Vente;

import java.util.Optional;

public interface VenteRepository extends JpaRepository<Vente,Long>{

   Optional<Vente> findVenteByCode(String code );

}
