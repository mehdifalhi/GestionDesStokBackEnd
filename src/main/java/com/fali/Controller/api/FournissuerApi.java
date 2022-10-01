package com.fali.Controller.api;

import com.fali.Dto.FournisseurDto;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api("/fournisseur")
public interface FournissuerApi {
    @PostMapping(value ="/fournisseur/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto save(@RequestBody FournisseurDto dto);
    @GetMapping(value ="/fournisseur/{idFournisseur}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto findById(@PathVariable("idFournisseur")Long idFournisseur);
    @GetMapping(value ="/fournisseur/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FournisseurDto> findAll();
    @DeleteMapping(value ="/fournisseur/delete/{idFournisseur}")
    void deleteById(@PathVariable("idFournisseur")Long idFournisseur);
}
