package com.fali.Controller.api;

import com.fali.Dto.ClientDto;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api("/clients")
public interface ClientApi {
    @PostMapping(value ="/clients/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
     public ClientDto save(@RequestBody ClientDto dto);
    @GetMapping(value ="/clients/{idClient}" ,produces = MediaType.APPLICATION_JSON_VALUE)
     public ClientDto findById(@PathVariable Long idClient);
    @GetMapping(value ="/clients/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDto> findAll();
    @DeleteMapping(value ="/clients/delete/idClient")
    void deleteById(@PathVariable Long idClient);
}
