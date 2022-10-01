package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fali.entites.CommandeClient;

import java.util.Optional;


public interface ComClientRepository extends JpaRepository<CommandeClient,Long>{


    Optional<CommandeClient> findCommandeClientByCode(String code);
}
