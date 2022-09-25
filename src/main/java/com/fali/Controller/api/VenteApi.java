package com.fali.Controller.api;

import com.fali.Dto.VenteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface VenteApi {
    @PostMapping(value = "/vente/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public VenteDto save(VenteDto dto);
    @GetMapping(value = "/vente/{idVente}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public  VenteDto findById(Long idVente);
    @GetMapping(value = "/vente/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VenteDto> findAll();
    @DeleteMapping(value = "/vente/delete/idVente")
    void deleteById(Long idVente);
}
