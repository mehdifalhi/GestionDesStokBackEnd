package com.fali.services;

import com.fali.Dto.VenteDto;

import java.util.List;

public interface VenteService {

    public VenteDto save(VenteDto dto);

    public  VenteDto findById(Long idVente);

    public List<VenteDto> findAll();

    void deleteById(Long idVente);
}
