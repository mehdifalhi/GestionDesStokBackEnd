package com.fali.Controller.api;

import com.fali.Dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface ClientApi {
    @PostMapping(value = "/clients/create",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto save(ClientDto dto);
    @GetMapping(value = "/clients/{idClient}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDto findById(Long idClient);
    @GetMapping(value = "/clients/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDto> findAll();
    @DeleteMapping(value = "/clients/delete/idClient")
    void deleteById(Long idClient);
}
