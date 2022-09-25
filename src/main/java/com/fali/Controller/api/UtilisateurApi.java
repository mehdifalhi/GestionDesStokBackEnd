package com.fali.Controller.api;

import com.fali.Dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface UtilisateurApi {
    @PostMapping(value = "/utilisateur/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)

    public UtilisateurDto save(UtilisateurDto dto);
    @GetMapping(value = "/utilisateur/{idUtilisateur}" ,produces = MediaType.APPLICATION_JSON_VALUE)

    public UtilisateurDto findById(Long idUtilisateur);
    @GetMapping(value = "/utilisateur/all" ,produces = MediaType.APPLICATION_JSON_VALUE)

    public List<UtilisateurDto> findAll();
    @DeleteMapping(value = "/utilisateur/delete/idUtilisateur")
    void deleteById(Long idUtilisateur);
}
