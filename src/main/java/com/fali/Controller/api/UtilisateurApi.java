package com.fali.Controller.api;

import com.fali.Dto.UtilisateurDto;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/utilisateur")
public interface UtilisateurApi {
    @PostMapping(value ="/utilisateur/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurDto save(@RequestBody UtilisateurDto dto);
    @GetMapping(value ="/utilisateur/{idUtilisateur}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public UtilisateurDto findById(@PathVariable("idUtilisateur")Long idUtilisateur);
    @GetMapping(value ="/utilisateur/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UtilisateurDto> findAll();
    @DeleteMapping(value ="/utilisateur/delete/{idUtilisateur}")
    void deleteById(@PathVariable("idUtilisateur")Long idUtilisateur);
}
