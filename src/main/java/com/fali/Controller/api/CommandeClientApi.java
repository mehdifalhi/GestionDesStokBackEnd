package com.fali.Controller.api;

import com.fali.Dto.CommandeClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api("/commandeClient")
public interface CommandeClientApi {
    @PostMapping(value ="/commandeClient/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto save(@RequestBody CommandeClientDto dto);
    @GetMapping(value ="/commandeClient/{idCommandeClient}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findById(@RequestParam(value = "idCommandeClient",required = false) Long id);
    @GetMapping(value ="/commandeClient/{code}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    CommandeClientDto findByCode(@RequestParam(value = "code",required = false) String code);
    @GetMapping(value ="/commandeClient/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    List<CommandeClientDto> findAll();
    @DeleteMapping(value ="/commandeClient/delete/{idCommandeClient}")
    void  delete(@PathVariable("idCommandeClient") Long idCommandeClient);
}
