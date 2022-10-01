package com.fali.Controller.api;

import com.fali.Dto.VenteDto;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/vente")
public interface VenteApi {
    @PostMapping(value ="/vente/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public VenteDto save(@RequestBody VenteDto dto);
    @GetMapping(value ="/vente/{idVente}" ,produces = MediaType.APPLICATION_JSON_VALUE)
     public  VenteDto findById(@PathVariable("idVente") Long idVente);
    @GetMapping(value ="/vente/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
     public List<VenteDto> findAll();
    @DeleteMapping(value ="/vente/delete/{idVente}")
    void deleteById(@PathVariable("idVente")Long idVente);
}
