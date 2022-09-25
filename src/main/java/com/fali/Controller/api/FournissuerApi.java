package com.fali.Controller.api;

import com.fali.Dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface FournissuerApi {
    @PostMapping(value = "/fournisseur/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto save(FournisseurDto dto);
    @GetMapping(value = "/fournisseur/{idFournisseur}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public FournisseurDto findById(Long idFournisseur);
    @GetMapping(value = "/fournisseur/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FournisseurDto> findAll();
    @DeleteMapping(value = "/fournisseur/delete/idFournisseur")
    void deleteById(Long idFournisseur);
}
