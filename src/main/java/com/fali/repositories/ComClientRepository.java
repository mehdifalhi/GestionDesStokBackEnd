package com.fali.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fali.entites.CommandeClient;


public interface ComClientRepository extends JpaRepository<CommandeClient,Long>{

}
