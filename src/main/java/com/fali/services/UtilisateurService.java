package com.fali.services;

import com.fali.Dto.FournisseurDto;
import com.fali.Dto.UtilisateurDto;

import java.util.List;

public interface UtilisateurService {

    public UtilisateurDto save(UtilisateurDto dto);

    public UtilisateurDto findById(Long idUtilisateur);

    public List<UtilisateurDto> findAll();

    void deleteById(Long idUtilisateur);
}
