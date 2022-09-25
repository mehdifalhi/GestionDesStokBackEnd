package com.fali.services.imp;

import com.fali.Dto.CategoryDto;
import com.fali.Dto.ClientDto;
import com.fali.entites.Client;
import com.fali.repositories.ClientRepository;
import com.fali.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@Slf4j
public class ClientServiceImp implements ClientService {

    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    @Override
    public ClientDto save(ClientDto dto) {
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

    @Override
    public ClientDto findById(Long idClient) {
        Optional<Client> client = clientRepository.findById(idClient);
        return Optional.of(ClientDto.fromEntity(client.get()))
                .orElseThrow(()->
        new RuntimeException("idClient not found" + idClient));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idClient) {

        clientRepository.deleteById(idClient);

    }
}
