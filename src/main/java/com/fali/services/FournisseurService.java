package com.fali.services;

import com.fali.Dto.ClientDto;
import com.fali.Dto.FournisseurDto;

import java.util.List;

public interface FournisseurService {

    public FournisseurDto save(FournisseurDto dto);

    public FournisseurDto findById(Long idFournisseur);

    public List<FournisseurDto> findAll();

    void deleteById(Long idFournisseur);
}
