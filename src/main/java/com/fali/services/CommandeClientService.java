package com.fali.services;

import com.fali.Dto.ArticleDto;
import com.fali.Dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto dto);

    CommandeClientDto findById(Long idCommandeClient);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto> findAll();

    void  delete(Long idCommandeClient);
}
