package com.fali.Controller;

import com.fali.Controller.api.CommandeClientApi;
import com.fali.Dto.CommandeClientDto;
import com.fali.services.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;
    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService){
        this.commandeClientService=commandeClientService;
    }
    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        return commandeClientService.save(dto);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        return commandeClientService.findById(id);
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return commandeClientService.findByCode(code);
    }

    @Override
    public List<CommandeClientDto> findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void delete(Long idCommandeClient) {
     commandeClientService.delete(idCommandeClient);
    }
}
