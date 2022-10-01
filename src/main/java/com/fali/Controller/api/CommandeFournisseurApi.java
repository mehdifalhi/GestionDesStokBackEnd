package com.fali.Controller.api;

import com.fali.Dto.CommandeFournisseurDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("/commandeFournisseur")
public interface CommandeFournisseurApi {
    @PostMapping(value ="/commandeFournisseur/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeFournisseurDto save(@RequestBody CommandeFournisseurDto dto);
    @GetMapping(value ="/commandeFournisseur/{idCommandeClient}" ,produces = MediaType.APPLICATION_JSON_VALUE)

    CommandeFournisseurDto findById(@RequestParam(value = "idCommandeClient",required = false) Long idCommandeFournisseur);
    @GetMapping(value ="/commandeFournisseur/{code}" ,produces = MediaType.APPLICATION_JSON_VALUE)

    CommandeFournisseurDto findByCode(@RequestParam(value = "code",required = false) String code);
    @GetMapping(value ="/commandeFournisseur/all" ,produces = MediaType.APPLICATION_JSON_VALUE)

    List<CommandeFournisseurDto> findAll();
    @DeleteMapping(value ="/commandeFournisseur/delete/{idCommandeClient}")

    void  delete(@PathVariable("idCommandeClient")Long idCommandeFournisseur);
}
