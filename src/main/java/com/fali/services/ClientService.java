package com.fali.services;


import com.fali.Dto.ClientDto;

import java.util.List;

public interface ClientService {

    public ClientDto save(ClientDto dto);

    public ClientDto findById(Long idClient);

    public List<ClientDto> findAll();

    void deleteById(Long idClient);
}
